package com.yg.instaclone.presenter.fragment

import com.yg.instaclone.R
import com.yg.instaclone.fragment.my.align.MyAlignFragment
import com.yg.instaclone.fragment.my.align.MyAlignVO
import com.yg.instaclone.presenter.BasePresenter

class MyFragAlignPresenter : BasePresenter<MyAlignFragment>(){
    private lateinit var alignList : ArrayList<MyAlignVO>
    fun initView(){
        alignList = ArrayList()
        alignList.add(MyAlignVO(R.drawable.pic1, false))
        alignList.add(MyAlignVO(R.drawable.pic2, true))
        alignList.add(MyAlignVO(R.drawable.pic3, false))
        alignList.add(MyAlignVO(R.drawable.pic4, false))
        alignList.add(MyAlignVO(R.drawable.pikapika, true))

        view!!.onInitAlign(alignList)
    }
}