package com.github.sky.github.ui.search

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import com.github.sky.github.base.vm.ListViewModel
import com.github.sky.github.bean.Repo
import com.github.sky.github.bean.Resource
import com.github.sky.github.bean.SearchResult
import com.github.sky.github.repository.RepoRepository

/**
 * Created by fuyuxian on 2018/1/11.
 *
 */
class SearchViewModel : ListViewModel() {

    private var inited = false
    var page = 1
    val query: MutableLiveData<String> = MutableLiveData()
    val searchResult: LiveData<Resource<SearchResult>> by lazy {
        Transformations.switchMap(query, { search ->
            return@switchMap RepoRepository.search(search, page)
        })
    }

    fun init(){
        if (!inited) {
            query.postValue("a")
            inited = true
        }
    }

    override fun hasMore() = searchResult.value?.data?.items?.size ?: 0 > 0

    override fun next() {
        if (hasMore()) {
            ++page
            query.postValue(query.value)
        }
    }
}