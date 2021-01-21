package com.example.brastlewarkmobiletest.data.api

import com.example.brastlewarkmobiletest.data.model.MainResponse
import kotlinx.coroutines.Deferred

import retrofit2.http.GET

interface GnomeApi {

    @GET("/rrafols/mobile_test/master/data.json")
    fun getGnomes(): Deferred<MainResponse>
}