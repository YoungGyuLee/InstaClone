package com.yg.instaclone.fragment.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.yg.instaclone.R
import com.yg.instaclone.presenter.fragment.HomeFragPresenter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    lateinit var feedsAdapter : HomeFeedAdapter
    lateinit var storysAdapter : HomeStoryAdapter
    lateinit var feedsRequestManager : RequestManager
    lateinit var storysRequestManager : RequestManager
    lateinit var homeFragPresenter: HomeFragPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_home, container, false)
        return v
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeFragPresenter = HomeFragPresenter()
        homeFragPresenter.view = this
        //HomeFragPresenter가 잡을 뷰를 나(HomeFragment)로 설정.
    }

    override fun onStart() {
        super.onStart()
        homeFragPresenter.initView()
    }

    fun onInitFeeds(feeds : ArrayList<HomeFeedVO>){
        feedsRequestManager = Glide.with(this)
        feedsAdapter = HomeFeedAdapter(feeds, activity!!.supportFragmentManager, feedsRequestManager)
        rv_home_feed.layoutManager = LinearLayoutManager(activity)
        rv_home_feed.adapter = feedsAdapter
    }

    fun onInitStorys(storys : ArrayList<HomeStoryVO>){
        storysRequestManager = Glide.with(this)
        storysAdapter = HomeStoryAdapter(storys, storysRequestManager)
        rv_home_story.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rv_home_story.adapter = storysAdapter
    }
}