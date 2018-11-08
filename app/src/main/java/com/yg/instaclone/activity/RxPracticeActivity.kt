package com.yg.instaclone.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jakewharton.rxbinding3.view.clicks
import com.yg.instaclone.R
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_rx_practice.*

class RxPracticeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx_practice)

        val inc = btn_up.clicks().map { +1 }

        val dec = btn_down.clicks().map { -1 }

        Observable.merge(inc, dec)
                .scan(0){acc : Int, value : Int -> acc + value}
                .subscribe{tv_result.text = it.toString()}
        //merge : 이벤트(여기서는 연산) 합치기
        //scan : 이벤트 발생을 지켜보다가 이벤트가 발생하면 해야할 일 처리(map과 유사)


        Observable.just(tv_rx.text.toString())
                .map { it + " RxRX" }
                .subscribe{tv_rx.text = it}
        //Observable : 아이템(이벤트) 만들기를 위한 클래스
        //just : 해당 인자를 가지고 이벤트를 만들어낸다는 뜻.
        //map : 해당 인자를 갖고 이벤트를 만들 때 어떤 일을 할지 정의
        //subscribe : 해당 인자를 갖고 이벤드를 만들고 그 일이 발생했을 때의 결과 처리.


//        Observable.just(btn_up.callOnClick())
//                .map { tv_result.toString().toInt() + 1 }
//                .subscribe {  tv_result.text = it.toString() }
//
//        Observable.just(btn_down.callOnClick())
//                .map { tv_result.toString().toInt() - 1 }
//                .subscribe{ tv_result.text = it.toString() }
    }

//    @TestOnly
//    fun testFun(){
//        abs
//    }
}
