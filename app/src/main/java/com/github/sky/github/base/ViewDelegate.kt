package com.github.sky.github.base

import android.view.View

/**
 * Created by fuyuxian on 2018/1/23.
 *
 */
open class ViewDelegate {

    fun hideLoading(loadingStatusView: IListView.LoadingStatusView?) {
        loadingStatusView?.apply {
            list?.visibility = View.VISIBLE
            progressBar?.visibility = View.GONE
            message?.visibility = View.GONE
            reload?.visibility = View.GONE
        }
    }

    fun showLoading(loadingStatusView: IListView.LoadingStatusView?) {
        loadingStatusView?.apply {
            list?.visibility = View.VISIBLE
            progressBar?.visibility = View.VISIBLE
            message?.visibility = View.GONE
            reload?.visibility = View.GONE
        }
    }
}