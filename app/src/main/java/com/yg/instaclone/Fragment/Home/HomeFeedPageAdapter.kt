package com.yg.instaclone.Fragment.Home

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.util.Log

class HomeFeedPageAdapter(fm : FragmentManager, var images : ArrayList<Int>) : FragmentStatePagerAdapter(fm) {
    lateinit var fragments : ArrayList<HomeFeedImage>

    init {

    }

    override fun getItem(position: Int): Fragment {
        Log.v("position", position.toString())
        return HomeFeedImage.create(images[position])
    }

    override fun getCount(): Int = images.size

}