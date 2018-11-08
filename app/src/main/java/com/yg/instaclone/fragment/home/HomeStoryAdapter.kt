package com.yg.instaclone.fragment.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.yg.instaclone.R

class HomeStoryAdapter(var storys : ArrayList<HomeStoryVO>, var requestManager: RequestManager) : RecyclerView.Adapter<HomeStoryViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeStoryViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.story_item,parent,false)
        return HomeStoryViewHolder(mainView)
    }

    override fun getItemCount(): Int = storys.size

    override fun onBindViewHolder(holder: HomeStoryViewHolder, position: Int) {
        requestManager.load(storys[position].proFile).into(holder.storyProfile)
        holder.storyName.text = storys[position].name
        if(position != 0)
            holder.storyAdd.visibility = View.GONE
    }
}