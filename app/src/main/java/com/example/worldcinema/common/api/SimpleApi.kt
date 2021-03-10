package com.mrz.apiwork.api

import com.mrz.apiwork.model.Cover
import com.mrz.apiwork.model.Post
import retrofit2.Response
import retrofit2.http.*

interface SimpleApi {

    @Headers("Authorization", "Bearer {225228}")
    @GET("/movies/cover")
    suspend fun getImg(): Response<Cover>

    @POST("auth/register")
    suspend fun register(
        @Body post: Post
    ): Response<Post>

}