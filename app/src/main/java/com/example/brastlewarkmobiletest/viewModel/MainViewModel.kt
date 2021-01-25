package com.example.brastlewarkmobiletest.viewModel

import androidx.lifecycle.MutableLiveData
import com.example.brastlewarkmobiletest.data.model.GnomeEntity
import com.example.brastlewarkmobiletest.data.repo.Repository
import com.example.brastlewarkmobiletest.utils.SingleLiveEvent
import com.example.brastlewarkmobiletest.utils.StateResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainViewModel(private val repo: Repository) : BaseViewModel() {

    val showLoading = MutableLiveData<Boolean>()
    val mList = MutableLiveData<List<GnomeEntity>>()
    val showError = SingleLiveEvent<String>()
    val navigateToDetail = SingleLiveEvent<GnomeEntity>()
    var searchText: String = ""
        set(value) {
            field = value
            filterData()
        }

    init {
        loadData()
    }

    private fun loadData() {
        showLoading.value = true
        launch {

            val result = withContext(Dispatchers.IO) { repo.getGnomeList() }
            showLoading.value = false
            when (result) {
                is StateResult.Success -> mList.value = result.data.gnomeList
                is StateResult.Error -> showError.value = result.exception.message
            }
        }
    }

    fun gnomeClicked(itemSelected: GnomeEntity) {
        navigateToDetail.value = itemSelected
    }

    private fun filterData() {
        if (searchText.isEmpty()) {
            resetList()
            return
        }
        var filteredElements = mList.value?.filter { it.name.contains(searchText) }
        mList.value = filteredElements?.sortedBy { it.name }
    }

    fun resetList() {
        loadData()
    }
}