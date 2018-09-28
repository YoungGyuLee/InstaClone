package com.yg.instaclone.Fragment.Home

import android.support.v4.view.ViewPager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.yg.instaclone.R

class HomeFeedViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    var feedProfile = itemView.findViewById(R.id.image_feed_profile) as ImageView
    var feedName = itemView.findViewById(R.id.tv_feed_name) as TextView
    var feedImages = itemView.findViewById(R.id.vp_feed_images) as ViewPager
}