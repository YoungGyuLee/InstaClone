package com.yg.instaclone.activity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.yg.instaclone.fragment.add.gallery.AddGalleryFragment
import com.yg.instaclone.fragment.add.photo.AddPhotoFragment
import com.yg.instaclone.fragment.add.video.AddVideoFragment

class AddAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return AddGalleryFragment()
            }
            1 -> {
                return AddPhotoFragment()
            }
            2 -> {
                return AddVideoFragment()
            }
        }
        return AddGalleryFragment()
    }
    override fun getCount(): Int = 3
}