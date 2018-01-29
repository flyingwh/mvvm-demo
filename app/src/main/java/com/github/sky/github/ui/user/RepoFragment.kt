package com.github.sky.github.ui.user

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.github.sky.github.R
import com.github.sky.github.bean.Repo
import com.github.sky.github.bean.Status
import com.github.sky.github.repository.RepoRepository
import com.github.sky.github.ui.search.RepoAdapter
import kotlinx.android.synthetic.main.layout_recycler_view.*

/**
 * Created by fuyuxian on 2018/1/11.
 *
 */
class RepoFragment : Fragment() {

    private val repos = ArrayList<Repo>()
    private val adapter = RepoAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_recycler_view, null)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        val userName = arguments.getString("userName")
        RepoRepository.getRepos(userName).observe(this, Observer {
            when (it?.status) {
                Status.Loading -> progressBar.visibility = View.VISIBLE
                Status.Success -> {
                    progressBar.visibility = View.GONE
                    repos.clear()
                    repos.addAll(it.data!!)
                    adapter.notifyDataSetChanged()
                }
                Status.Error -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(context, "something is wrong , ${it.message}", Toast.LENGTH_SHORT).show()
                }
            }

        })
    }


}