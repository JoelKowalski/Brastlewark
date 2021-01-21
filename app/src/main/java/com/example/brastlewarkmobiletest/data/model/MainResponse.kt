package com.example.brastlewarkmobiletest.data.model

import com.google.gson.annotations.SerializedName

class MainResponse (
    @SerializedName("Brastlewark")
    val gnomeList: List<GnomeEntity>
)