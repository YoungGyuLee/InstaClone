package com.yg.instaclone.presenter.fragment

import android.content.Context
import com.yg.instaclone.fragment.add.gallery.AddGalleryFragment
import com.yg.instaclone.fragment.add.gallery.AddGalleryVO
import com.yg.instaclone.presenter.BasePresenter
import com.yg.instaclone.util.GalleryManager

class AddGalleryPresenter : BasePresenter<AddGalleryFragment>(){

    private lateinit var galleryList : ArrayList<AddGalleryVO>

    fun initView(context : Context){
        galleryList = ArrayList()
        galleryList = GalleryManager(context).getAllGalleryPath()


        view!!.initGallery(galleryList)
    }

    fun setRepresentImage(image : String){
        view!!.changeRepresent(image)
    }

}