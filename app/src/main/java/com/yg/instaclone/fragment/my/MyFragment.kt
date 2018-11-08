package com.yg.instaclone.fragment.my

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jakewharton.rxbinding3.view.clicks
import com.yg.instaclone.R
import com.yg.instaclone.fragment.my.align.MyAlignFragment
import com.yg.instaclone.fragment.my.grid.MyGridFragment
import com.yg.instaclone.presenter.fragment.MyFragPresenter
import kotlinx.android.synthetic.main.fragment_my.*

class MyFragment : Fragment() {

    lateinit var myFragPresenter: MyFragPresenter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_my, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myFragPresenter = MyFragPresenter()
        myFragPresenter.view = this
    }

    override fun onStart() {
        super.onStart()
        setOnBinding()
        myFragPresenter.initView()
    }

    fun addFragment(fragment : Fragment){
        val fm = activity!!.supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.add(R.id.frame_my, fragment)
        transaction.commit()
    }

    fun replaceFragment(fragment : Fragment){
        val fm = activity!!.supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.frame_my, fragment)
        transaction.commit()
    }

    fun setOnBinding(){
        btn_my_grid.clicks().subscribe { myFragPresenter.replaceFragment(MyGridFragment()) }
        btn_my_align.clicks().subscribe { myFragPresenter.replaceFragment(MyAlignFragment()) }
    }
}