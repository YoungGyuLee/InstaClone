package com.yg.instaclone.activity

import android.annotation.TargetApi
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.yg.instaclone.R
import com.yg.instaclone.presenter.activity.AddActPresenter
import com.yg.instaclone.util.PermissionHelper
import kotlinx.android.synthetic.main.activity_add.*

//@Suppress("UNCHECKED_CAST")
class AddActivity : AppCompatActivity() {

    lateinit var addActPresenter : AddActPresenter
    val PERMISSIONS = arrayOf("android.permission.CAMERA",
            "android.permission.READ_EXTERNAL_STORAGE")
    val PERMISSIONS_REQUEST_CODE = 1000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
//        val aaa = intent.getSerializableExtra("array") as? ArrayList<Testing>
//        Log.v("aaa", aaa!![0].name)

        initPresenter()
        addActPresenter.initView()

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            //퍼미션 상태 확인
//            Log.v("Add", "Init")
//
//            if (!hasPermissions(PERMISSIONS)) {
//                //퍼미션 허가 안되어있다면 사용자에게 요청
//                Log.v("Add", "Init pn")
//                requestPermissions(PERMISSIONS, PERMISSIONS_REQUEST_CODE)
//            }else{
//                Log.v("Add", "Init po")
//                initPresenter()
//                addActPresenter.initView()
//            }
//        }
    }

    override fun onResume() {
        super.onResume()
        if (!PermissionHelper.hasCameraPermission(this))
            PermissionHelper.requestCameraPermission(this)

        if (!PermissionHelper.hasReadExternalStoragePermission(this))
            PermissionHelper.requestReadExternalStoragePermission(this)

    }


    fun initPresenter(){
        addActPresenter = AddActPresenter()
        addActPresenter.view = this
    }

    fun initView(){
        tab_add.addTab(tab_add.newTab().setText("갤러리"))
        tab_add.addTab(tab_add.newTab().setText("사진"))
        tab_add.addTab(tab_add.newTab().setText("동영상"))

        val tabAdapter = AddAdapter(supportFragmentManager)

        vp_add_main.adapter = tabAdapter
        vp_add_main.currentItem = 0
        vp_add_main.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_add))


        tab_add.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }
            override fun onTabSelected(tab: TabLayout.Tab?) {
                vp_add_main.currentItem = tab!!.position
            }
        })


    }

    private fun hasPermissions(permissions: Array<String>): Boolean {
        var result: Int

        //스트링 배열에 있는 퍼미션들의 허가 상태 여부 확인
        for (perms in permissions) {

            result = ContextCompat.checkSelfPermission(this, perms)

            if (result == PackageManager.PERMISSION_DENIED) {
                //허가 안된 퍼미션 발견
                return false
            }
        }

        //모든 퍼미션이 허가되었음
        return true
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//
//        when (requestCode) {
//            PERMISSIONS_REQUEST_CODE -> if (grantResults.isEmpty()) {
//                val cameraPermissionAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED
//
//                if (!cameraPermissionAccepted)
//                    showDialogForPermission("앱을 실행하려면 퍼미션을 허가하셔야합니다.")
//            }
//        }

        if (!PermissionHelper.hasCameraPermission(this)) {
            Toast.makeText(this, "Camera permission is needed to run this application", Toast.LENGTH_LONG)
                    .show()
            if (!PermissionHelper.shouldShowRequestPermissionRationaleCamera(this)) {
                // Permission denied with checking "Do not ask again".
                PermissionHelper.launchPermissionSettings(this)
            }
            finish()
        }

        if (!PermissionHelper.hasReadExternalStoragePermission(this)) {
            Toast.makeText(this, "Read External Storage permission is needed to run this application", Toast.LENGTH_LONG)
                    .show()
            if (!PermissionHelper.shouldShowRequestPermissionRationaleReadExternalStorage(this)) {
                // Permission denied with checking "Do not ask again".
                PermissionHelper.launchPermissionSettings(this)
            }
            finish()
        }

    }

    @TargetApi(Build.VERSION_CODES.M)
    private fun showDialogForPermission(msg: String) {

        val builder = AlertDialog.Builder(this@AddActivity)
        builder.setTitle("알림")
        builder.setMessage(msg)
        builder.setCancelable(false)
        builder.setPositiveButton("예", DialogInterface.OnClickListener { dialog, id -> requestPermissions(PERMISSIONS, PERMISSIONS_REQUEST_CODE) })
        builder.setNegativeButton("아니오", DialogInterface.OnClickListener { arg0, arg1 -> finish() })
        builder.create().show()
    }




}
