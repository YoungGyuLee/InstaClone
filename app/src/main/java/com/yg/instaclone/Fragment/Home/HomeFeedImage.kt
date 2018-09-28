package com.yg.instaclone.Fragment.Home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.yg.instaclone.R
import kotlinx.android.synthetic.main.fragment_home_feed.*

class HomeFeedImage : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_home_feed, container, false)

        return v
    }

    companion object {
        fun create(imageUrl: Int): HomeFeedImage {
            val fragment = HomeFeedImage()
            val args = Bundle()
            args.putInt("image", imageUrl)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onStart() {
        super.onStart()
        Glide.with(this).load(arguments!!.getInt("image"))
                .into(image_feed_content)

    }

}