package com.example.brastlewarkmobiletest.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class GnomeEntity(

    @SerializedName("name")
    val name: String = "",
    @SerializedName("thumbnail")
    val image: String = "",
    @SerializedName("age")
    val age: Int = 0,
    @SerializedName("weight")
    val weight: Double = 0.0,
    @SerializedName("height")
    val height: Double = 0.0,
    @SerializedName("hair_color")
    val hairColor: String = "",
    @SerializedName("professions")
    val professions: List<String>,
    @SerializedName("friends")
    val friends: List<String>
) : Parcelable