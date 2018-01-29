package com.github.sky.github.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.util.Log
import com.github.sky.github.api.GithubClient
import com.github.sky.github.base.common.request
import com.github.sky.github.bean.Repo
import com.github.sky.github.bean.Resource
import com.github.sky.github.bean.SearchResult
import com.github.sky.github.bean.Status

/**
 * Created by fuyuxian on 2018/1/10.
 *
 */
object RepoRepository {

    fun search(query: String, page: Int = 0): LiveData<Resource<SearchResult>> {

        return request {
            GithubClient.githubService.search(query, page)
        }

    }

    fun getRepos(name: String): LiveData<Resource<List<Repo>>> {

        return request {
            GithubClient.githubService.getRepos(name)
        }
    }
}