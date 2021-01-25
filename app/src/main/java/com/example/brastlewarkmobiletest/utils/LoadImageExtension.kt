package com.example.brastlewarkmobiletest.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders

fun ImageView.loadImage(imageUrl: String) {
    val image = imageUrl.replace("http://", "https://")
    val imageUrlGlide = GlideUrl(
        image, LazyHeaders.Builder()
            .addHeader("User-Agent", "your-user-agent")
            .build()
    )
    Glide.with(this)
        .load(imageUrlGlide)
        .centerCrop()
        .into(this)
}