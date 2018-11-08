package com.yg.instaclone.fragment.my.grid

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.fragment_my_grid_item.view.*

class MyGridViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    var greedImage : ImageView = itemView.image_my_grid
}