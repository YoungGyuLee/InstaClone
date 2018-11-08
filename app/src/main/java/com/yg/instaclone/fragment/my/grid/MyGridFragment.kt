package com.yg.instaclone.fragment.my.grid

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.yg.instaclone.R
import com.yg.instaclone.presenter.fragment.MyFragGridPresenter
import kotlinx.android.synthetic.main.fragment_my_grid.*

class MyGridFragment : Fragment() {

    private lateinit var myGridPresenter : MyFragGridPresenter
    private lateinit var requestManager : RequestManager
    private lateinit var myGridAdapter : MyGridAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_my_grid, container, false)

        return v
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myGridPresenter = MyFragGridPresenter()
        myGridPresenter.view = this

    }

    override fun onStart() {
        super.onStart()
        myGridPresenter.initView()
    }

    fun onInitGrid(gridImages : ArrayList<MyGridVO>){
        requestManager = Glide.with(this)
        myGridAdapter = MyGridAdapter(gridImages, requestManager)
        rv_my_grid.layoutManager = GridLayoutManager(context, 3)
        rv_my_grid.adapter = myGridAdapter
    }



}