package com.github.sky.github.bean

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by fuyuxian on 2018/1/10.
 *
 */
data class User(
        val login: String,
        @SerializedName("avatar_url")
        val avatarUrl: String,
        val id: String
) : Serializable