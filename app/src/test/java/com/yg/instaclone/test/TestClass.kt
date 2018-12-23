package com.yg.instaclone.test

import org.junit.Rule
import org.junit.Test

class TestClass {
    var a : Int = 0
    var b : Int = 0
    @Rule
//    @Before
//    fun setValues(){
//        a = 10
//        b = 20
//    }

    @Test
    fun calcSum(){
        print(a + b)
    }
}