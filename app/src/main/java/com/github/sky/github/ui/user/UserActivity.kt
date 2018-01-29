package com.github.sky.github.ui.user

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.github.sky.github.R
import com.github.sky.github.bean.User
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.activity_user.*
import kotlinx.android.synthetic.main.content_user.*

class UserActivity : AppCompatActivity() {

    val user: User by lazy { intent.getSerializableExtra("user") as User }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        setSupportActionBar(toolbar)


        Picasso.with(this)
                .load(user.avatarUrl)
                .into(avatar)

        name.text = user.login

        tabLayout.setupWithViewPager(viewPager)
        viewPager.adapter = UserFragmentPagerAdapter(supportFragmentManager, user.login)

    }

}
