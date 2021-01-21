package com.example.brastlewarkmobiletest.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.brastlewarkmobiletest.R
import com.example.brastlewarkmobiletest.data.model.GnomeEntity
import com.example.brastlewarkmobiletest.ui.adapter.FriendsRecyclerView
import com.example.brastlewarkmobiletest.utils.Constants
import com.example.brastlewarkmobiletest.utils.Constants.Companion.EXTRA_GNOME_BUNDLE
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {

    private lateinit var friendAdapter: FriendsRecyclerView

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
        fillDetail(gnomeSelected)
        initRecycleView(gnomeSelected.friends)
    }

    private fun initRecycleView(friends: List<String>){

        friendAdapter = FriendsRecyclerView(friends)
        recyclerView.apply {
            layoutManager = GridLayoutManager(this@DetailActivity, Constants.COLUMNS_MAIN_ACTIVITY)
            adapter = friendAdapter
        }
    }

    private fun fillDetail(gnomeSelected:GnomeEntity){
        detail_view_name.text = gnomeSelected.name
        detail_view_weight.text = gnomeSelected.weight.toString()
        detail_view_height.text = gnomeSelected.height.toString()

        detail_view_gender.text = if(gnomeSelected.age%2==0) "Male" else "Female"
    }
}