package com.yg.instaclone.presenter.fragment

import com.yg.instaclone.R
import com.yg.instaclone.fragment.my.grid.MyGridFragment
import com.yg.instaclone.fragment.my.grid.MyGridVO
import com.yg.instaclone.presenter.BasePresenter

class MyFragGridPresenter : BasePresenter<MyGridFragment>(){

    private lateinit var gridImages : ArrayList<MyGridVO>

    fun initView(){
        gridImages = ArrayList()



        gridImages.add(MyGridVO(R.drawable.pic1, false))
        gridImages.add(MyGridVO(R.drawable.pic2, true))
        gridImages.add(MyGridVO(R.drawable.pic3, false))
        gridImages.add(MyGridVO(R.drawable.pic4, false))
        gridImages.add(MyGridVO(R.drawable.pikapika, true))

        view!!.onInitGrid(gridImages)
    }
}
