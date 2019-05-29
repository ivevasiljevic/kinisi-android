package com.lution.kinisi.network.interceptors

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by ivasil on 5/29/2019
 */

class HeaderInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        return chain.proceed(chain
                .request()
                .newBuilder()
                .addHeader("Content-type", "application/json")
                .build())
    }
}