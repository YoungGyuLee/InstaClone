package com.yg.instaclone.util

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import com.yg.instaclone.fragment.add.gallery.AddGalleryVO

class GalleryManager(var context : Context) {

    fun getAllGalleryPath() : ArrayList<AddGalleryVO>{

        var galleryList : ArrayList<AddGalleryVO> = ArrayList()

        val uri : Uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI

        val projection = arrayOf(
                MediaStore.MediaColumns.DATA,
                MediaStore.Images.Media.DATE_ADDED)

        val cursor : Cursor = context.contentResolver.query(uri, projection, null, null, null)

        val columnData = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA)

        while (cursor.moveToNext()) {
            val photoVO = AddGalleryVO(cursor.getString(columnData), false)
            galleryList.add(photoVO)
        }

        cursor.close()

        return galleryList
    }


}