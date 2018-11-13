package com.yg.instaclone.fragment.add.gallery

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.yg.instaclone.R
import com.yg.instaclone.presenter.fragment.AddGalleryPresenter
import kotlinx.android.synthetic.main.fragment_add_gallery.*

class AddGalleryFragment : Fragment() {

    private lateinit var addGalleryPresenter: AddGalleryPresenter
    private lateinit var addGalleryAdapter: AddGalleryAdapter
    private lateinit var requestManager: RequestManager



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_add_gallery, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addGalleryPresenter = AddGalleryPresenter()
        addGalleryPresenter.view = this
    }

    override fun onStart() {
        super.onStart()
        addGalleryPresenter.initView(context!!)

    }

    fun initGallery(gallery : ArrayList<AddGalleryVO>){
        requestManager = Glide.with(this)
        addGalleryAdapter = AddGalleryAdapter(gallery, requestManager)
        rv_add_gallery.layoutManager = GridLayoutManager(context, 4)
        rv_add_gallery.adapter = addGalleryAdapter
    }
}