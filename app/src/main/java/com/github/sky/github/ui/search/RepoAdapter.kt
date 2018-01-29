package com.github.sky.github.ui.search

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.github.sky.github.R
import com.github.sky.github.base.BaseViewHolder
import com.github.sky.github.bean.Repo
import com.github.sky.github.ui.user.UserActivity
import com.squareup.picasso.Picasso

/**
 * Created by fuyuxian on 2018/1/11.
 *
 */
class RepoAdapter : RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {

    val repos: ArrayList<Repo> = ArrayList()

    override fun getItemCount(): Int {
        return repos.size
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_repo
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RepoAdapter.RepoViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(viewType, parent, false)

        return RepoViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepoAdapter.RepoViewHolder, position: Int) {
        holder.onBind(repos[position])
    }


    class RepoViewHolder(itemView: View) : BaseViewHolder(itemView) {

        private val avatar: ImageView by lazy { itemView.findViewById(R.id.avatar) as ImageView }
        private val name: TextView by lazy { itemView.findViewById(R.id.name) as TextView }
        private val description: TextView by lazy { itemView.findViewById(R.id.description) as TextView }

        override fun onBind(data: Any?) {
            if (data !is Repo) return

            Picasso.with(itemView.context)
                    .load(data.owner.avatarUrl)
                    .into(avatar)

            name.text = data.fullName
            description.text = data.description

            avatar.setOnClickListener {
                Intent(itemView.context, UserActivity::class.java)
                        .apply {
                            putExtra("user", data.owner)
                        }
                        .run { itemView.context.startActivity(this) }

            }
        }


    }
}