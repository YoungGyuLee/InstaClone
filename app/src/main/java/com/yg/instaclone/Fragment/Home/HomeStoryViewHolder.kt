package com.yg.instaclone.Fragment.Home

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.yg.instaclone.R

class HomeStoryViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    var storyProfile = itemView.findViewById(R.id.image_story_profile) as ImageView
    var storyName = itemView.findViewById(R.id.tv_story_name) as TextView
    var storyAdd = itemView.findViewById(R.id.image_story_add) as ImageView
}