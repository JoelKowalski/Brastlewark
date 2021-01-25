package com.example.brastlewarkmobiletest


import com.example.brastlewarkmobiletest.ui.ActivityMain
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`


import org.junit.Test

import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock


import org.mockito.runners.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class MockitoTest {

    @Test
    fun test_when_thenReturnOk() {
        val activity: ActivityMain = mock(ActivityMain::class.java)
        `when`(activity.packageName).thenReturn("com.example.brastlewarkmobiletest")
        assertThat((activity.packageName), `is`("com.example.brastlewarkmobiletest"))
    }

    @Test
    fun test_when_thenReturnKo() {
        val activity: ActivityMain = mock(ActivityMain::class.java)
        `when`(activity.packageName).thenReturn("test")
        assertThat((activity.packageName), `is`("test"))
    }
}
