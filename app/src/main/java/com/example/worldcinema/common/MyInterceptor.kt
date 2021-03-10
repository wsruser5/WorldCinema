package com.example.worldcinema.common

import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor: Interceptor{

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Authorization", "Bearer {225228}")
            .build()
        return chain.proceed(request)
    }

}