package com.yg.instaclone.fragment.my.grid

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.yg.instaclone.R

class MyGridAdapter(private var gridList : ArrayList<MyGridVO>, private var requestManager: RequestManager) : RecyclerView.Adapter<MyGridViewHolder>() {

    var height : Int = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyGridViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.fragment_my_grid_item,parent,false)
        height = parent.measuredWidth / 3
        //길이 조정을 위해 부모뷰의 가로 길이(사실상 fragment_my_grid_item)에 3을 나눔.
        return MyGridViewHolder(mainView)
    }

    override fun getItemCount(): Int = gridList.size

    override fun onBindViewHolder(holder: MyGridViewHolder, position: Int) {
        if(gridList[position].multi)
            println()

        requestManager.load(gridList[position].gridImage).into(holder.greedImage)

        val params = holder.greedImage.layoutParams
        params.height = height
        holder.greedImage.layoutParams = params

    }
}