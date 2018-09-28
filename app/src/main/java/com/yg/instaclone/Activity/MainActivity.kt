package com.yg.instaclone.Activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.yg.instaclone.Fragment.Home.HomeFeedPageAdapter
import com.yg.instaclone.Fragment.Home.HomeFragment
import com.yg.instaclone.R
import com.yg.instaclone.Testing
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    lateinit var arrList : ArrayList<Testing>
    lateinit var imageAdpater : HomeFeedPageAdapter
    lateinit var images : ArrayList<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        arrList = ArrayList()
//        arrList.add(Testing(1, "aaa"))
//        val intent = Intent(this, AddActivity::class.java)
//        intent.putExtra("array", arrList)
//        startActivity(intent)
//        images = ArrayList()
//        images.add(R.drawable.pic1)
//        images.add(R.drawable.pic2)
//        images.add(R.drawable.pic3)
//        images.add(R.drawable.pic4)
//
//        imageAdpater = HomeFeedPageAdapter(supportFragmentManager, images)

//        main_viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
//            override fun onPageScrollStateChanged(state: Int) {
//            }
//
//            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
//            }
//
//            override fun onPageSelected(position: Int) {
//            }
//
//        })

//        viewpager_main_activity.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
//            override fun onPageScrollStateChanged(state: Int) {
//            }
//
//            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
//            }
//
//            override fun onPageSelected(position: Int) {
//                dotsview_main.selectDot(position)
//                Log.v("페이지", position.toString())
//            }
//
//        })
        addFragment(HomeFragment())
    }

    fun addFragment(fragment : Fragment){
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.add(R.id.main_frame, fragment)
        transaction.commit()
    }

    fun replaceFragment(fragment : Fragment){
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.main_frame, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun clearSelected(){
        //btn_main_search.isSelected = false
        //btn_main_news.isSelected = false
    }

    override fun onClick(v: View?) {
        when(v){
            btn_main_home -> {
                clearSelected()
                btn_main_home.isSelected = true
                replaceFragment(HomeFragment())
            }
            btn_main_my -> {
                clearSelected()
                btn_main_my.isSelected = true
                //replaceFragment(MyFragment())
            }
        }
    }
}
