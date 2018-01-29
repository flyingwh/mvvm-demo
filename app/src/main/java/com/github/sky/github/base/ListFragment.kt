//package com.github.sky.github.base
//
//import android.support.v4.app.Fragment
//import android.support.v7.widget.RecyclerView
//import kotlinx.android.synthetic.main.layout_recycler_view.recyclerView
//import kotlinx.android.synthetic.main.loading_status.*
//
///**
// * Created by fuyuxian on 2018/1/15.
// *
// */
//abstract class ListFragment
//    : Fragment(), IListView {
//
//    override val adapter: HeaderFooterListAdapter by lazy {
//        HeaderFooterListAdapter().apply {
//            this.adapter = createAdapter()
//        }
//    }
//
//    override fun getRecyclerView(): RecyclerView {
//        return recyclerView
//    }
//
//    private val listViewDelegate = ListViewDelegate()
//    private val loadingStatusView by lazy {
//        IListView.LoadingStatusView(getRecyclerView(), progressBar, message, reload)
//    }
//
//    override fun showLoading() {
//        listViewDelegate.showLoading(loadingStatusView)
//    }
//
//    override fun hideLoading() {
//        listViewDelegate.hideLoading(loadingStatusView)
//    }
//
//    override fun showError() {
//        listViewDelegate.showError(loadingStatusView)
//    }
//
//}