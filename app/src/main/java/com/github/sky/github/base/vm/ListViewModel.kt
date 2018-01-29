package com.github.sky.github.base.vm

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

/**
 * Created by fuyuxian on 2018/1/15.
 *
 */
abstract class ListViewModel : ViewModel() {

//    val data = MutableLiveData<List<T>>()

    abstract fun hasMore(): Boolean

    abstract fun next()

}