package com.yg.instaclone.presenter.fragment

import android.support.v4.app.Fragment
import com.yg.instaclone.fragment.my.MyFragment
import com.yg.instaclone.fragment.my.grid.MyGridFragment
import com.yg.instaclone.presenter.BasePresenter

class MyFragPresenter : BasePresenter<MyFragment>() {

    fun initView(){
        view!!.addFragment(MyGridFragment())
    }

    fun replaceFragment(fragment : Fragment){
        view!!.replaceFragment(fragment)
    }
}