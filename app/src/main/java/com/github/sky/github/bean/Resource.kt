package com.github.sky.github.bean

/**
 * Created by fuyuxian on 2018/1/11.
 *
 */
data class Resource<out T>(
        val status: Status,
        val data: T? = null,
        val message: String? = null
)