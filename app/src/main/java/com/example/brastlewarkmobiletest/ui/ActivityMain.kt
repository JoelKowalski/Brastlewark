package com.example.brastlewarkmobiletest.ui

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.brastlewarkmobiletest.R
import com.example.brastlewarkmobiletest.data.model.GnomeEntity
import com.example.brastlewarkmobiletest.ui.adapter.MainRecyclerView
import com.example.brastlewarkmobiletest.utils.Constants.Companion.COLUMNS_MAIN_ACTIVITY
import com.example.brastlewarkmobiletest.viewModel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class ActivityMain: AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()
    private lateinit var gnomeAdapter: MainRecyclerView
    private lateinit var searchView: SearchView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecycleView()
        initViewModel()
    }

    private fun initRecycleView(){
        val listener: (itemSelected: GnomeEntity) -> Unit = { item ->
            viewModel.gnomeClicked(item)
        }

        gnomeAdapter = MainRecyclerView(listener)
        recyclerView.apply {
            layoutManager = GridLayoutManager(this@ActivityMain, COLUMNS_MAIN_ACTIVITY)
            adapter = gnomeAdapter
        }
    }

    private fun initViewModel() {
        viewModel.mList.observe(this, Observer { newCatsList ->
            gnomeAdapter.updateData(newCatsList!!)
        })

        viewModel.showLoading.observe(this, Observer { showLoading ->
            mainProgressBar.visibility = if (showLoading!!) View.VISIBLE else View.GONE
        })

        viewModel.showError.observe(this, Observer { showError ->
            Toast.makeText(this, showError, Toast.LENGTH_SHORT).show()
        })

        viewModel.navigateToDetail.observe(this, Observer { itemSelected ->
            if (itemSelected != null) startActivity(DetailActivity.getStartIntent(this, itemSelected))
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        searchView = menu?.findItem(R.id.searchView)?.actionView as SearchView
        configureSearch(searchView)
        return true
    }

    private fun configureSearch(searchView: SearchView)  {

        searchView.setOnCloseListener {
            viewModel.resetList()
            return@setOnCloseListener false
        }
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean { return true }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.searchText = newText ?: ""
                return true
            }
        })
    }
}