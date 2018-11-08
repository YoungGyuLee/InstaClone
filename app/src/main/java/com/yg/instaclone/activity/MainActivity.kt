package com.yg.instaclone.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.jakewharton.rxbinding3.view.clicks
import com.yg.instaclone.fragment.home.HomeFragment
import com.yg.instaclone.fragment.my.MyFragment
import com.yg.instaclone.fragment.news.NewsFragment
import com.yg.instaclone.fragment.search.SearchFragment
import com.yg.instaclone.presenter.activity.MainActPresenter
import com.yg.instaclone.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    private lateinit var mainActPresenter : MainActPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //startActivity(Intent(this, RxPracticeActivity::class.java))
        initPresenter()
        mainActPresenter.initView()
        setOnBinding()
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
        transaction.commit()
    }

    fun setOnBinding(){
        btn_main_home.clicks().subscribe { mainActPresenter.replaceFragment(HomeFragment()) }
        btn_main_my.clicks().subscribe { mainActPresenter.replaceFragment(MyFragment()) }
        btn_main_news.clicks().subscribe { mainActPresenter.replaceFragment(NewsFragment()) }
        btn_main_search.clicks().subscribe { mainActPresenter.replaceFragment(SearchFragment()) }
    }


    fun clearSelected(){
        //btn_main_search.isSelected = false
        //btn_main_news.isSelected = false
    }


    //Rx 적용으로 파기될 부분.
//    override fun onClick(v: View?) {
//        when(v){
//            btn_main_home -> {
//                clearSelected()
//                btn_main_home.isSelected = true
//                replaceFragment(HomeFragment())
//            }
//            btn_main_my -> {
//                clearSelected()
//                btn_main_my.isSelected = true
//                //replaceFragment(MyFragment())
//            }
//        }
//    }
}
