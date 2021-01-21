package com.example.brastlewarkmobiletest.data.api

import com.example.brastlewarkmobiletest.data.model.MainResponse
import kotlinx.coroutines.Deferred

import retrofit2.http.GET

interface GnomeApi {
    // Get route used to retrieve gnome data

    @GET("/rrafols/mobile_test/master/data.json")
    fun getGnomes(): Deferred<MainResponse>
}