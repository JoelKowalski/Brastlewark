package com.example.brastlewarkmobiletest.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.brastlewarkmobiletest.R
import com.example.brastlewarkmobiletest.data.model.GnomeEntity
import com.example.brastlewarkmobiletest.helper.loadImage
import com.example.brastlewarkmobiletest.utils.Constants.Companion.EXTRA_GNOME_BUNDLE
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context, itemSelected: GnomeEntity): Intent {
            return Intent(context, DetailActivity::class.java)
                .putExtra(EXTRA_GNOME_BUNDLE, itemSelected)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val gnomeSelected :GnomeEntity = intent.getParcelableExtra(EXTRA_GNOME_BUNDLE)
        detail_view_image.loadImage(gnomeSelected.image)
        detail_view_name.text = gnomeSelected.name

    }
}