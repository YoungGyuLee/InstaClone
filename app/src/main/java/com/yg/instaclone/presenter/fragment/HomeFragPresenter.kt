package com.yg.instaclone.presenter.fragment

import com.yg.instaclone.fragment.home.HomeFeedVO
import com.yg.instaclone.fragment.home.HomeFragment
import com.yg.instaclone.fragment.home.HomeStoryVO
import com.yg.instaclone.presenter.BasePresenter
import com.yg.instaclone.R

class HomeFragPresenter : BasePresenter<HomeFragment>() {

    private lateinit var feeds : ArrayList<HomeFeedVO>
    private lateinit var images : ArrayList<Int>
    private lateinit var images2 : ArrayList<Int>
    private lateinit var images3 : ArrayList<Int>


    private lateinit var storys : ArrayList<HomeStoryVO>


    fun initView(){
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


        storys = ArrayList()
        storys.add(HomeStoryVO(R.drawable.pikapika, "yg09"))
        storys.add(HomeStoryVO(R.drawable.pic1, "yg1"))
        storys.add(HomeStoryVO(R.drawable.pic2, "yg2"))


        view!!.onInitFeeds(feeds)
        view!!.onInitStorys(storys)
    }
}