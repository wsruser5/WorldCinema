package com.mrz.apiwork.repository

import com.mrz.apiwork.api.RetrofitInstance
import com.mrz.apiwork.model.Cover
import com.mrz.apiwork.model.Post
import retrofit2.Response

class Repository {

    suspend fun register(post: Post): Response<Post> {
        return RetrofitInstance.api.register(post)
    }

    suspend fun getImg(): Response<Cover> {
        return RetrofitInstance.api.getImg()
    }
}