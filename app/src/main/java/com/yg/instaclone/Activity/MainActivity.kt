package com.yg.instaclone.Activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yg.instaclone.R
import com.yg.instaclone.Testing

class MainActivity : AppCompatActivity() {

    lateinit var arrList : ArrayList<Testing>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        arrList = ArrayList()
        arrList.add(Testing(1, "aaa"))
        val intent = Intent(this, AddActivity::class.java)
        intent.putExtra("array", arrList)
        startActivity(intent)
    }
}
