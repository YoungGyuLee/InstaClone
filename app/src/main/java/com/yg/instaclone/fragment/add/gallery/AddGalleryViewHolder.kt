package com.yg.instaclone.fragment.add.gallery

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.yg.instaclone.R

class AddGalleryViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    var galleryList = itemView.findViewById(R.id.image_add_gallery_list) as ImageView

}