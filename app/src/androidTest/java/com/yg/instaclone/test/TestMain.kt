package com.yg.instaclone.test

import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.yg.instaclone.activity.MainActivity
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TestMain {

    //lateinit var myActivity : MainActivity

//    @Rule
//    public var mainRule : ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Rule @JvmField
    var mainRule : ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)


//    @Before
//    fun setActivity(){
//        myActivity = mainRule.activity
//    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        Assert.assertEquals("com.yg.instaclone", appContext.packageName)
    }

    @Test
    fun testSetBinding(){
        mainRule.activity.setOnBinding()
    }
}
