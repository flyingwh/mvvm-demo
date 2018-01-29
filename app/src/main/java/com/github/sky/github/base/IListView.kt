package com.github.sky.github.base

import android.support.v7.widget.RecyclerView
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

/**
 * Created by fuyuxian on 2018/1/15.
 *
 */
interface IListView : IView {

    val adapter: HeaderFooterListAdapter

    fun showError()
    fun showLoadingNextPage()
    fun getRecyclerView(): RecyclerView
    fun createAdapter(): RecyclerView.Adapter<out BaseViewHolder>

    data class LoadingStatusView(
            val list: RecyclerView?,
            val progressBar: ProgressBar?,
            val message: TextView?,
            val reload: Button?
    )
}