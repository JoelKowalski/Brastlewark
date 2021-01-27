package com.example.brastlewarkmobiletest.viewModel

import com.example.brastlewarkmobiletest.data.model.GnomeEntity
import com.example.brastlewarkmobiletest.data.repo.Repository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations



class MainViewModelTest {

    @Mock
    lateinit var repository: Repository


    lateinit var  mainViewModel: MainViewModel

    @Before
    fun initMocks(){
        MockitoAnnotations.initMocks(this)
        mainViewModel = MainViewModel(repository)
    }

    @Test
    fun gnomeClicked() {
        val gnome = GnomeEntity("prueba","",4,4.5,3.3,"", emptyList(), emptyList())
        mainViewModel.gnomeClicked(gnome)
        verify(mainViewModel).gnomeClicked(gnome)
    }

    @Test
    fun resetList() {


    }
}