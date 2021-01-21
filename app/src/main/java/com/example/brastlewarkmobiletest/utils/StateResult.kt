package com.example.brastlewarkmobiletest.utils

sealed class StateResult <out T : Any> {
    class Success<out T : Any>(val data: T) : StateResult<T>()
    class Error(val exception: Throwable) : StateResult<Nothing>()
}