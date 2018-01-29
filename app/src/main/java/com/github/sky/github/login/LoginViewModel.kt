package com.github.sky.github.login

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

/**
 * Created by fuyuxian on 2018/1/10.
 */
class LoginViewModel : ViewModel() {

    val loginResult = MutableLiveData<LoginResult>()
    val isRegistered = MutableLiveData<Boolean>()

    fun login(phoneNum: String, password: String): LiveData<LoginResult> {

        return loginResult
    }

    fun checkPhoneNum(phoneNum: String): LiveData<Boolean> {

        return isRegistered
    }

}