package com.github.sky.github.bean

import com.google.gson.annotations.SerializedName

/**
 * Created by fuyuxian on 2018/1/10.
 */
data class SearchResult(
        @SerializedName("total_count")
        val totalCount: Int,
        val items: List<Repo>,
        val page: Int = 1
)