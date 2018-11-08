package com.yg.instaclone.fragment.my.align

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.yg.instaclone.R

class MyAlignAdapter(var alignList : ArrayList<MyAlignVO>, var requestManager : RequestManager) : RecyclerView.Adapter<MyAlignViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAlignViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.fragment_my_align_item,parent,false)
        return MyAlignViewHolder(mainView)
    }

    override fun getItemCount(): Int = alignList.size

    override fun onBindViewHolder(holder: MyAlignViewHolder, position: Int) {
        requestManager.load(alignList[position].alignImage).into(holder.alignImages)
    }
}