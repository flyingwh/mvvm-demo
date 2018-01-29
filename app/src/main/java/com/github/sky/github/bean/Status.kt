package com.github.sky.github.bean

/**
 * Created by fuyuxian on 2018/1/11.
 *
 */
sealed class Status {
    object Success : Status()
    object Error : Status()
    object Loading : Status()
}

sealed class LoadingStatus {
    object NoData : LoadingStatus()
    object NoNetwork : LoadingStatus()
    object Error : LoadingStatus()
}