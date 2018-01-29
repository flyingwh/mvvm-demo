package com.github.sky.github.ui.user

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by fuyuxian on 2018/1/11.
 *
 */
class UserFragmentPagerAdapter(fragmentManager: FragmentManager, val userName: String)
    : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return RepoFragment().apply {
            val arguments = Bundle()
            arguments.putString("userName", userName)
            setArguments(arguments)
        }

    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Repos"
            1 -> "Gists"
            else -> ""
        }
    }
}