package com.github.sky.github.base

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.sky.github.R

/**
 * Created by fuyuxian on 2018/1/18.
 *
 */
class HeaderFooterListAdapter : RecyclerView.Adapter<BaseViewHolder>() {

    var adapter: RecyclerView.Adapter<out BaseViewHolder>? = null
    val headers = ArrayList<Item<Any, BaseViewHolder>>()
    val footers = ArrayList<Item<Any, BaseViewHolder>>()

    override fun getItemViewType(position: Int): Int {
        return when {
            isHeader(position) -> headers[position].layout
            isFooter(position) -> footers[position - headers.size - adapter!!.itemCount].layout
            else -> adapter!!.getItemViewType(position - headers.size)
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {

        when {
            isHeader(position) -> holder.onBind(headers[position].data)
            isFooter(position) -> {
                val pos = position - headers.size - adapter!!.itemCount
                holder.onBind(footers[pos].data)
            }

            else -> {
                (adapter as RecyclerView.Adapter<BaseViewHolder>)
                        .onBindViewHolder(holder, position - headers.size)
            }
        }
    }

    override fun getItemCount(): Int {
        return headers.size + footers.size + adapter!!.itemCount
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return headers.union(footers).find { it.layout == viewType }?.let {
            val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
            it.viewHolderClass.getConstructor(View::class.java).newInstance(view)
        } ?: adapter!!.onCreateViewHolder(parent, viewType)
    }


    private fun isHeader(position: Int): Boolean = position < headers.size

    private fun isFooter(position: Int): Boolean = position >= headers.size + adapter!!.itemCount


    object LoadingFooter : Item<Any, LoadingFooterVH>(R.layout.item_load_next_page, LoadingFooterVH::class.java, null)
    class LoadingFooterVH(view: View) : BaseViewHolder(view) {
        override fun onBind(data: Any?) {
        }
    }

    open class Item<out T, out VH : BaseViewHolder>(@LayoutRes val layout: Int, val viewHolderClass: Class<out VH>, val data: T?)
}