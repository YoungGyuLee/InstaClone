package com.yg.instaclone.Fragment.Home

import android.support.v4.app.FragmentManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.yg.instaclone.R

class HomeFeedAdapter(var feeds : ArrayList<HomeFeedVO>, var fm : FragmentManager, var requestManager : RequestManager) : RecyclerView.Adapter<HomeFeedViewHolder>() {

    lateinit var imageAdpater : ArrayList<HomeFeedPageAdapter>
    lateinit var viewPageSate : HashMap<Int, Int>

    init {
        viewPageSate = HashMap()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeFeedViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.feed_item,parent,false)
//        imageAdpater = ArrayList()
//        for (i in 0 until feeds.size)
//            imageAdpater.add(HomeFeedPageAdapter(fm, feeds[i].images))
        return HomeFeedViewHolder(mainView)
    }

    override fun getItemCount(): Int = feeds.size

    override fun onBindViewHolder(holder: HomeFeedViewHolder, position: Int) {
        holder.feedName.text = feeds[position].name
        requestManager.load(feeds[position].profile).into(holder.feedProfile)
        holder.feedImages.adapter = HomeFeedPageAdapter(fm, feeds[position].images)
        holder.feedImages.id = position+1
        holder.feedImages.offscreenPageLimit = 3
        if(viewPageSate.containsKey(position)){
            Log.v("viewHolder", position.toString())
            holder.feedImages.currentItem = viewPageSate[position]!!
        }
    }

    override fun onViewRecycled(holder: HomeFeedViewHolder) {
        viewPageSate[holder.adapterPosition] = holder.feedImages.currentItem
        super.onViewRecycled(holder)
    }
}
