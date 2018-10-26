package com.yg.instaclone.Activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.yg.instaclone.Fragment.Home.HomeFragment
import com.yg.instaclone.Presenter.ActivityPresenter.MainActPresenter
import com.yg.instaclone.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var mainActPresenter : MainActPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initPresenter()
        mainActPresenter.initView()
    }

    fun initPresenter(){
        mainActPresenter = MainActPresenter()
        mainActPresenter.view = this
    }

    fun addFragment(fragment : Fragment){
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.add(R.id.main_frame, fragment)
        transaction.commit()
    }

    fun replaceFragment(fragment : Fragment){
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.main_frame, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun clearSelected(){
        //btn_main_search.isSelected = false
        //btn_main_news.isSelected = false
    }

    override fun onClick(v: View?) {
        when(v){
            btn_main_home -> {
                clearSelected()
                btn_main_home.isSelected = true
                replaceFragment(HomeFragment())
            }
            btn_main_my -> {
                clearSelected()
                btn_main_my.isSelected = true
                //replaceFragment(MyFragment())
            }
        }
    }
}
