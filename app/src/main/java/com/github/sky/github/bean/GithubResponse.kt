package com.github.sky.github.bean

import retrofit2.Response

/**
 * Created by fuyuxian on 2018/1/10.
 *
 */
class GithubResponse<T> {
    var message: String? = ""
    var code: Int = 200
    var body: T? = null

    constructor(error: Throwable) {
        code = 500
        message = error.message
    }

    constructor(response: Response<T>) {
        if (response.isSuccessful) {
            body = response.body()
        } else {
            code = response.code()
            message = response.message()
        }
    }
}