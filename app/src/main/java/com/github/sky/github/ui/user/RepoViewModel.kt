package com.github.sky.github.ui.user

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.github.sky.github.bean.Repo
import com.github.sky.github.bean.Resource
import com.github.sky.github.repository.RepoRepository

/**
 * Created by fuyuxian on 2018/1/11.
 *
 */
class RepoViewModel() : ViewModel() {

    lateinit var userName: String

    val repos : LiveData<Resource<List<Repo>>> by lazy {
        RepoRepository.getRepos(userName)
    }

}