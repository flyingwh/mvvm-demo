package com.github.sky.github.ui.search

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import com.github.sky.github.R
import com.github.sky.github.base.ListActivity
import com.github.sky.github.base.vm.ListViewModel
import com.github.sky.github.bean.Repo
import com.github.sky.github.bean.Resource
import com.github.sky.github.bean.SearchResult
import com.github.sky.github.bean.Status
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.content_search.*
import kotlinx.android.synthetic.main.loading_status.*

class SearchActivity : ListActivity() {

    override val viewModel: SearchViewModel
        get() = ViewModelProviders.of(this).get(SearchViewModel::class.java)

    override fun createAdapter(): RecyclerView.Adapter<RepoAdapter.RepoViewHolder> {
        return RepoAdapter()
    }


    override fun getLayoutRes(): Int {
        return R.layout.activity_search
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)

        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.query.postValue(query)

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                return false
            }

        })

        viewModel.searchResult.observe(this, Observer<Resource<SearchResult>> {

            when (it?.status) {
                Status.Loading -> {
                    showLoading()
                }
                Status.Success -> {
                    hideLoading()
                    (adapter.adapter as RepoAdapter).repos.addAll(it.data!!.items.subList(0, 9))
                    adapter.notifyDataSetChanged()
                }
                Status.Error -> {
                    showError()

                    message.text = it.message

                    reload.setOnClickListener {
                        viewModel.query.postValue(search.query.toString())
                    }
                }
            }

        })

        //
        viewModel.init()

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

}
