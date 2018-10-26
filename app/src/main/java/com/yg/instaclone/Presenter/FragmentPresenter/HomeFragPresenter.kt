package com.yg.instaclone.Presenter.FragmentPresenter

import com.yg.instaclone.Fragment.Home.HomeFeedVO
import com.yg.instaclone.Fragment.Home.HomeFragment
import com.yg.instaclone.Presenter.BasePresenter
import com.yg.instaclone.R

class HomeFragPresenter : BasePresenter<HomeFragment>() {

    private lateinit var feeds : ArrayList<HomeFeedVO>
    private lateinit var images : ArrayList<Int>
    private lateinit var images2 : ArrayList<Int>
    private lateinit var images3 : ArrayList<Int>

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


        view!!.onCompleteInit(feeds)
    }
}