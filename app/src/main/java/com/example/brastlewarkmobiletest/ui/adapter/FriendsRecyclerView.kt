package com.example.brastlewarkmobiletest.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.brastlewarkmobiletest.R
import kotlinx.android.synthetic.main.item_list_view_friend.view.*

class FriendsRecyclerView (private val list:List<String>) :
    RecyclerView.Adapter<FriendsRecyclerView.FriendsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_list_view_friend, parent, false)
        val holder = FriendsViewHolder(view)

        return holder
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: FriendsViewHolder, position: Int) {

        if (position != RecyclerView.NO_POSITION) {
            val friend: String = list[position]
            holder.bind(friend)
        }
    }

    class FriendsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(friend: String) {
            itemView.friend_name.text = friend
        }
    }
}