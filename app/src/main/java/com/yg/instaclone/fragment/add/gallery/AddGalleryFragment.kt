package com.yg.instaclone.fragment.add.gallery

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.Log
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
    private lateinit var gridLayoutManager : GridLayoutManager

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
        addGalleryAdapter = AddGalleryAdapter(gallery, requestManager, addGalleryPresenter)
        gridLayoutManager = GridLayoutManager(context, 4)
        addGalleryPresenter.setRepresentImage(gallery[0].path)
//        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup(){
//            override fun getSpanSize(position: Int) =
//                    if (addGalleryAdapter.getItemViewType(position) == AddGalleryAdapter.HEADER) 4 else 1
//        }


        rv_add_gallery.layoutManager = gridLayoutManager
        rv_add_gallery.adapter = addGalleryAdapter
    }

    fun changeRepresent(image : String){
        Log.v("image", image)

//        val params = image_add_represent.layoutParams
//        params.height = params.width
//        image_add_represent.layoutParams = params

        requestManager.load(image).into(image_add_represent)

        val dm = context!!.resources.displayMetrics
        val height = dm.widthPixels
        image_add_represent.minimumHeight = height


    }
}