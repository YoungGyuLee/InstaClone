package com.yg.instaclone.presenter.activity

import android.support.v4.app.Fragment
import com.yg.instaclone.activity.MainActivity
import com.yg.instaclone.fragment.home.HomeFragment
import com.yg.instaclone.presenter.BasePresenter

class MainActPresenter : BasePresenter<MainActivity>() {
    fun initView(){
        view!!.addFragment(HomeFragment())
    }

    fun replaceFragment(fragment : Fragment){
        view!!.replaceFragment(fragment)
    }
}