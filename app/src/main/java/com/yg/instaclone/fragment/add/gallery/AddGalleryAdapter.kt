package com.yg.instaclone.fragment.add.gallery

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.yg.instaclone.R

class AddGalleryAdapter(var addGalleryList : ArrayList<AddGalleryVO>, var requestManager: RequestManager) : RecyclerView.Adapter<AddGalleryViewHolder>() {

    var height = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddGalleryViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.fragment_add_gallery_item,parent,false)
        height = parent.measuredWidth / 4
        //길이 조정을 위해 부모뷰의 가로 길이(사실상 image_add_gallery_item)에 4을 나눔.
        return AddGalleryViewHolder(mainView)
    }

    override fun getItemCount(): Int = addGalleryList.size

    override fun onBindViewHolder(holder: AddGalleryViewHolder, position: Int) {
        requestManager.load(addGalleryList[position].path).into(holder.galleryList)

        val params = holder.galleryList.layoutParams
        params.height = height
        holder.galleryList.layoutParams = params
    }
}