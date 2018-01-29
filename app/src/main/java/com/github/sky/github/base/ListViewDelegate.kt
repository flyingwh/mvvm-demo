package com.github.sky.github.base

import android.view.View

/**
 * Created by fuyuxian on 2018/1/15.
 *
 */
class ListViewDelegate : ViewDelegate() {

    fun hideLoading(adapter: HeaderFooterListAdapter, loadingStatusView: IListView.LoadingStatusView?) {
        hideLoading(loadingStatusView)
        adapter.footers.remove(HeaderFooterListAdapter.LoadingFooter)
    }

    fun showError(loadingStatusView: IListView.LoadingStatusView?) {
        loadingStatusView?.apply {
            list?.visibility = View.GONE
            progressBar?.visibility = View.GONE
            message?.visibility = View.VISIBLE
            reload?.visibility = View.VISIBLE
        }
    }

    fun showLoadingNextPage(adapter: HeaderFooterListAdapter) {
        if (!adapter.footers.contains(HeaderFooterListAdapter.LoadingFooter)) {
            adapter.footers.add(HeaderFooterListAdapter.LoadingFooter)
            adapter.notifyItemInserted(adapter.itemCount)
        }

    }
}