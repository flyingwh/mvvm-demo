package com.github.sky.github.base

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by fuyuxian on 2018/1/18.
 *
 */
abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun onBind(data: Any?)
}