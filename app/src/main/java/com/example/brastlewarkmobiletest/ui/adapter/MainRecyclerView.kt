package com.example.brastlewarkmobiletest.ui.adapter

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.example.brastlewarkmobiletest.R
import com.example.brastlewarkmobiletest.data.model.GnomeEntity
import kotlinx.android.synthetic.main.item_list_view_gnome.view.*
import java.net.URL
import kotlin.properties.Delegates


class MainRecyclerView(private val listener: (itemSelected: GnomeEntity) -> Unit) :
    RecyclerView.Adapter<MainRecyclerView.GnomeViewHolder>() {

    private var mList: List<GnomeEntity> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GnomeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_list_view_gnome, parent, false)
        val holder = GnomeViewHolder(view)

        holder.itemView.card_container.setOnClickListener {
            if (holder.adapterPosition != RecyclerView.NO_POSITION) {
                listener.invoke(mList[holder.adapterPosition])
            }
        }
        return holder
    }

    override fun getItemCount(): Int = mList.size

    override fun onBindViewHolder(holder: GnomeViewHolder, position: Int) {

        if (position != RecyclerView.NO_POSITION) {
            val gnome: GnomeEntity = mList[position]
            holder.bind(gnome)
        }
    }

    fun updateData(gnomeList: List<GnomeEntity>) {
        mList = gnomeList
    }

    class GnomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(gnome: GnomeEntity) {
            itemView.card_view_image_name.text = gnome.name
            itemView.card_view_image_age.text = gnome.age.toString()
            val image = gnome.image.replace("http://", "https://")



            val imageUrl = GlideUrl(
                image, LazyHeaders.Builder()
                    .addHeader("User-Agent", System.getProperty("http.agent"))
                    .build()
            )
            Glide.with(itemView.card_view_image)
                .load(imageUrl)
                .placeholder(R.drawable.placeholder)
                .into(itemView.card_view_image)


        }
    }
}