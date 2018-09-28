package com.yg.instaclone.Fragment.Home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.yg.instaclone.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    lateinit var feeds : ArrayList<HomeFeedVO>
    lateinit var feedsAdapter : HomeFeedAdapter
    lateinit var requestManager : RequestManager
    lateinit var images : ArrayList<Int>
    lateinit var images2 : ArrayList<Int>
    lateinit var images3 : ArrayList<Int>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_home, container, false)

        return v
    }


    override fun onStart() {
        super.onStart()
        images = ArrayList()
        images.add(R.drawable.pic1)
        images.add(R.drawable.pic2)
        images.add(R.drawable.pic3)
        images.add(R.drawable.pic4)

        images2 = ArrayList()
        images2.add(R.drawable.pic4)
        images2.add(R.drawable.pic3)
        images2.add(R.drawable.pic2)
        images2.add(R.drawable.pic1)

        images3 = ArrayList()
        images3.add(R.drawable.pic4)
        images3.add(R.drawable.pic3)
        images3.add(R.drawable.pic2)
        images3.add(R.drawable.pic1)


        feeds = ArrayList()
        feeds.add(HomeFeedVO(R.drawable.pikapika, "yg09", images))
        feeds.add(HomeFeedVO(R.drawable.pic2, "ygyg091", images2))
        feeds.add(HomeFeedVO(R.drawable.pic3, "ygyg0912", images3))

        requestManager = Glide.with(this)
        feedsAdapter = HomeFeedAdapter(feeds, activity!!.supportFragmentManager, requestManager)
        rv_home_feed.layoutManager = LinearLayoutManager(activity)
        rv_home_feed.adapter = feedsAdapter



    }
}