package com.yg.instaclone.fragment.add.gallery

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.jakewharton.rxbinding3.view.clicks
import com.yg.instaclone.R
import com.yg.instaclone.presenter.fragment.AddGalleryPresenter

class AddGalleryAdapter(private var addGalleryList : ArrayList<AddGalleryVO>, private var requestManager: RequestManager, private val addGalleryPresenter: AddGalleryPresenter) : RecyclerView.Adapter<AddGalleryViewHolder>() {

    var height = 0

    companion object {
        val HEADER : Int = 0
        val ITEM : Int = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddGalleryViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.fragment_add_gallery_item,parent,false)
        height = parent.measuredWidth / 4
        //길이 조정을 위해 부모뷰의 가로 길이(사실상 image_add_gallery_item)에 4을 나눔.
        return AddGalleryViewHolder(mainView)
    }

    override fun getItemCount(): Int = addGalleryList.size

    override fun onBindViewHolder(holder: AddGalleryViewHolder, position: Int) {
        requestManager.load(addGalleryList[position].path).into(holder.galleryList)
        holder.galleryList.clicks().subscribe{addGalleryPresenter.setRepresentImage(addGalleryList[position].path)}


        val params = holder.galleryList.layoutParams
        params.height = height
        holder.galleryList.layoutParams = params
    }



    //헤더가 필요할 줄 알았는데 뷰 구성 잘못 파악해서 결국 의미 없어진 부분.
//    override fun getItemViewType(position: Int) =
//            if(position == 0) HEADER else ITEM
}