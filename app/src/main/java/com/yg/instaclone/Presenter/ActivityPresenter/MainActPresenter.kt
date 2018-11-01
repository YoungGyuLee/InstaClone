package com.yg.instaclone.Presenter.ActivityPresenter

import android.support.v4.app.Fragment
import com.yg.instaclone.Activity.MainActivity
import com.yg.instaclone.Fragment.Home.HomeFragment
import com.yg.instaclone.Presenter.BasePresenter

class MainActPresenter : BasePresenter<MainActivity>() {
    fun initView(){
        view!!.addFragment(HomeFragment())
    }

    fun replaceFragment(fragment : Fragment){
        view!!.replaceFragment(fragment)
    }
}