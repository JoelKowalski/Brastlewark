package com.example.brastlewarkmobiletest.data.repo

import com.example.brastlewarkmobiletest.data.api.GnomeApi
import com.example.brastlewarkmobiletest.data.model.GnomeEntity
import com.example.brastlewarkmobiletest.data.model.MainResponse
import com.example.brastlewarkmobiletest.utils.StateResult

interface Repository {
    suspend fun getGnomeList(): StateResult<MainResponse>
}

class GnomeRepositoryImpl(private val api: GnomeApi) : Repository {
    override suspend fun getGnomeList(): StateResult<MainResponse> {
        return try {
            val result = api.getGnomes().await()
            StateResult.Success(result)
        } catch (ex: Exception) {
            StateResult.Error(ex)
        }
    }
}
