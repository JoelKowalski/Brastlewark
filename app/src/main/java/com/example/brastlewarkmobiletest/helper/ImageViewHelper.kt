package com.example.brastlewarkmobiletest.helper

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(image: String) {
    Glide.with(this)
        .load(image)
        .centerCrop()
        .into(this)

}