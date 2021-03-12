package com.mrz.worldcinema.api

import com.example.worldcinema.data.EpisodesList
import com.example.worldcinema.data.LastVideoInfo
import com.example.worldcinema.data.MovieInfo
import com.example.worldcinema.data.MoviesListItem
import com.mrz.apikotlin.api.MovieGson
import com.mrz.apikotlin.api.Token
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.*

interface ApiRequest {
    @Headers("Authorization: Bearer ktoya")
    @POST("auth/register")
    @FormUrlEncoded
    suspend fun signup(@Field("email") email: String,
                       @Field("password") password: String,
                       @Field("firstName") firstName: String,
                       @Field("lastName") lastName: String):Response<String>

    @POST("auth/login")
    @FormUrlEncoded
    suspend fun signin(@Field("email") email: String, @Field("password") password: String):Response<Token>

    @GET("movies/cover")
    fun getCovers(): Response<MovieGson>

    @GET("movies/cover")
    fun getCover(): Observable<MovieGson>

    @GET("movies")
    fun getMovies(
        @Query("filter") filter: String): Observable<List<MoviesListItem>>

    @GET("movies/{movieId}")
    fun getFilm(
        @Path("movieId") movieId: String): Observable<MovieInfo>

    @GET("movies/1/episodes")
    fun getEpisodes(): Observable<List<EpisodesList>>

    @Headers("Authorization: Bearer 265462")
    @GET("usermovies")
    fun getLastVideo(
            @Query("filter") filter: String): Observable<List<LastVideoInfo>>
}