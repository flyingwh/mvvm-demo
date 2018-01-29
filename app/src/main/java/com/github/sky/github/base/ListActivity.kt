package com.github.sky.github.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.github.sky.github.R
import com.github.sky.github.base.vm.ListViewModel
import kotlinx.android.synthetic.main.layout_recycler_view.recyclerView
import kotlinx.android.synthetic.main.loading_status.*

/**
 * Created by fuyuxian on 2018/1/15.
 *
 */
abstract class ListActivity
    : AppCompatActivity(), IListView {

    abstract val viewModel: ListViewModel

    override val adapter: HeaderFooterListAdapter by lazy {
        HeaderFooterListAdapter().apply {
            this.adapter = createAdapter()
        }
    }

    override fun getRecyclerView(): RecyclerView {
        return recyclerView
    }

    private val listViewDelegate = ListViewDelegate()
    private val loadingStatusView by lazy {
        IListView.LoadingStatusView(getRecyclerView(), progressBar, message, reload)
    }

    private fun initRecyclerView() {
        getRecyclerView().adapter = adapter
        getRecyclerView().layoutManager = LinearLayoutManager(this)

        getRecyclerView().addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val layoutManager = recyclerView.layoutManager
                if (layoutManager is LinearLayoutManager
                        && layoutManager.findLastVisibleItemPosition() == adapter.itemCount - 1) {
                    showLoadingNextPage()
                    viewModel.next()
                }
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        initRecyclerView()
    }

    override fun showLoading() {
        listViewDelegate.showLoading(loadingStatusView)
    }

    override fun hideLoading() {
        listViewDelegate.hideLoading(adapter, loadingStatusView)
    }

    override fun showError() {
        listViewDelegate.showError(loadingStatusView)
    }

    override fun showLoadingNextPage() {
        listViewDelegate.showLoadingNextPage(adapter)
    }

    open fun getLayoutRes(): Int {
        return R.layout.layout_recycler_view
    }

}