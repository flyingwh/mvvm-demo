package com.github.sky.github.base.common

import android.arch.lifecycle.*
import com.github.sky.github.base.IListView
import com.github.sky.github.bean.GithubResponse
import com.github.sky.github.bean.Resource
import com.github.sky.github.bean.Status

/**
 * Created by fuyuxian on 2018/1/23.
 *
 */

fun <T> request(block: () -> LiveData<GithubResponse<T>>): LiveData<Resource<T>> {

    return requestWithoutLoading {
        block.invoke()
    }.apply {
        this as MutableLiveData
        postValue(Resource(Status.Loading))
    }
}

fun <T> requestWithoutLoading(block: () -> LiveData<GithubResponse<T>>): LiveData<Resource<T>> {

    val result = block.invoke()
    return Transformations.map(result, { response ->
        return@map if (response.code in 200..299) Resource(Status.Success, response.body)
        else Resource(Status.Error, null, response.message)
    })
}

fun <T> observe(owner: LifecycleOwner, view: IListView, liveData: LiveData<Resource<T>>, block: (T) -> Unit) {
    liveData.observe(owner, Observer<Resource<T>> {
        when (it?.status) {
            Status.Loading -> {
                view.showLoading()
            }
            Status.Success -> {
                view.hideLoading()
                block.invoke(it.data!!)
            }
            Status.Error -> {
                view.showError()

//                message.text = it.message

            }
        }
    })
}