package com.github.sky.github.bean

import com.google.gson.annotations.SerializedName

/**
 * Created by fuyuxian on 2018/1/10.
 */
data class Repo(
        val id : String,
        val name: String,
        @SerializedName("full_name")
        val fullName: String,
        val owner: User,
        val description: String
)