package com.github.sky.github.api

import android.arch.lifecycle.LiveData
import com.github.sky.github.bean.GithubResponse
import com.github.sky.github.bean.Repo
import com.github.sky.github.bean.SearchResult
import com.github.sky.github.bean.User
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by fuyuxian on 2018/1/10.
 *
 */
interface GithubService {

    @GET("users/{userName}")
    fun getUser(@Path("userName") userName: String): LiveData<GithubResponse<User>>

    @GET("users/{userName}/repos")
    fun getRepos(@Path("userName") userName: String): LiveData<GithubResponse<List<Repo>>>

    @GET("search/repositories")
    fun search(@Query("q") query: String, @Query("page") page: Int = 0): LiveData<GithubResponse<SearchResult>>
}