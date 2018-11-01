package com.yg.instaclone.Fragment.Home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.yg.instaclone.Presenter.FragmentPresenter.HomeFragPresenter
import com.yg.instaclone.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    lateinit var feedsAdapter : HomeFeedAdapter
    lateinit var requestManager : RequestManager
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

    fun onCompleteInit(feeds : ArrayList<HomeFeedVO>){
        requestManager = Glide.with(this)
        feedsAdapter = HomeFeedAdapter(feeds, activity!!.supportFragmentManager, requestManager)
        rv_home_feed.layoutManager = LinearLayoutManager(activity)
        rv_home_feed.adapter = feedsAdapter
    }
}