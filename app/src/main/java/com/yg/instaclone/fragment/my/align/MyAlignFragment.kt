package com.yg.instaclone.fragment.my.align

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.yg.instaclone.R
import com.yg.instaclone.presenter.fragment.MyFragAlignPresenter
import kotlinx.android.synthetic.main.fragment_my_grid.*

class MyAlignFragment : Fragment(){
    lateinit var myFragAlignPresenter : MyFragAlignPresenter
    lateinit var requestManager: RequestManager
    lateinit var myAlignAdapter: MyAlignAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_my_grid, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myFragAlignPresenter = MyFragAlignPresenter()
        myFragAlignPresenter.view = this
    }

    override fun onStart() {
        super.onStart()
        myFragAlignPresenter.initView()
    }

    fun onInitAlign(alignList : ArrayList<MyAlignVO>){
        requestManager = Glide.with(this)
        myAlignAdapter = MyAlignAdapter(alignList, requestManager)
        rv_my_grid.layoutManager = LinearLayoutManager(context)
        rv_my_grid.adapter = myAlignAdapter
    }
}