/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.sky.github.api


import android.arch.lifecycle.LiveData
import com.github.sky.github.bean.GithubResponse
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type
import java.util.concurrent.atomic.AtomicBoolean

/**
 * A Retrofit adapterthat converts the Call into a LiveData of GithubResponse.
 * @param <R>
</R> */
class LiveDataCallAdapter<R>(private val responseType: Type) : CallAdapter<R, LiveData<GithubResponse<R>>> {

    override fun responseType(): Type {
        return responseType
    }

    override fun adapt(call: Call<R>): LiveData<GithubResponse<R>> {
        return object : LiveData<GithubResponse<R>>() {
            internal var started = AtomicBoolean(false)
            override fun onActive() {
                super.onActive()
                if (started.compareAndSet(false, true)) {
                    call.enqueue(object : Callback<R> {
                        override fun onResponse(call: Call<R>, response: Response<R>) {
                            postValue(GithubResponse(response))
                        }

                        override fun onFailure(call: Call<R>, throwable: Throwable) {
                            postValue(GithubResponse<R>(throwable))
                        }
                    })
                }
            }
        }
    }
}
