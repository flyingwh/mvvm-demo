//package com.github.sky.github.base
//
//import android.support.v7.app.AppCompatActivity
//
///**
// * Created by fuyuxian on 2018/1/23.
// */
//abstract class BaseActivity : AppCompatActivity(), IView {
//
//    val viewDelegate = ViewDelegate()
//    private val loadingView by lazy {
//        if (getLoadingViewResId() != 0) {
//            findViewById(getLoadingViewResId()) as
//        }
//    }
//
//
//    override fun showLoading() {
//        viewDelegate.showLoading(lo)
//    }
//
//    override fun getLoadingViewResId(): Int {
//        return 0
//    }
//}