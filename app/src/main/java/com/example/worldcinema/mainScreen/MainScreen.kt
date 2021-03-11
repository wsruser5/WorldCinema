package com.example.worldcinema.mainScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.worldcinema.*
import com.example.worldcinema.common.adapter.MyAdapter
import com.example.worldcinema.data.MoviesList
import com.google.gson.GsonBuilder
import com.mrz.worldcinema.api.ApiRequest
import com.mrz.worldcinema.constants.Constants.Companion.BASE_URL
import com.mrz.worldcinema.constants.Constants.Companion.IMG_URL
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main_screen.*
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainScreen : AppCompatActivity() {

    private val myAdapter by lazy { MyAdapter() }
    private var url: String = ""
    private lateinit var movies: ArrayList<MoviesList>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        val movies = listOf(
            getPopularMovies()
        )

        val category = listOf(
            getCategory()
        )

        items_container.adapter = GroupAdapter<GroupieViewHolder>().apply { addAll(movies) }
        category_container.adapter = GroupAdapter<GroupieViewHolder>().apply { addAll(category) }

        getCover()
    }

    private fun getMovies() {
        buildNewRetrofit().create(ApiRequest::class.java).getCover().subscribeOn(
            Schedulers.newThread()
        )
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                url = it.backgroundImage ?: ""
            }.subscribeBy(
                onNext = {
                    Glide.with(this)
                        .load(IMG_URL+url)
                        .into(ivMain)
                    Log.d("testGif", "Succesful Movies")
                    Toast.makeText(this, "Good", Toast.LENGTH_SHORT).show()
                }, onError = {
                    Log.d("testGif", "onError url = $url")
                    Toast.makeText(this, "Bad Movies", Toast.LENGTH_SHORT).show()
                }
            )
    }


    private fun getCover() {
        buildNewRetrofit().create(ApiRequest::class.java).getCover().subscribeOn(
            Schedulers.newThread()
        )
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                url = it.backgroundImage ?: ""
            }.subscribeBy(
                onNext = {
                    Glide.with(this)
                        .load(IMG_URL+url)
                        .into(ivMain)
                    Log.d("testGif", "Succesful")
                    Toast.makeText(this, "Good", Toast.LENGTH_SHORT).show()
                }, onError = {
                    Log.d("testGif", "onError url = $url")
                    Toast.makeText(this, "Bad", Toast.LENGTH_SHORT).show()
                }
            )
    }

    fun buildNewRetrofit(): Retrofit {

        val client = OkHttpClient.Builder()
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        return retrofit

    }

    private fun getCategory(): Item {
        return TitleContainer(
                ::onItemClick,
                listOf(
                        MovieTitle(
                                CategoryTitle(
                                        "В тренде"
                                )
                        ),
                        MovieTitle(
                                CategoryTitle(
                                        "Новое"
                                )
                        ),
                        MovieTitle(
                                CategoryTitle(
                                        "Для Вас"
                                )
                        )
                )
        )

    }

    private fun getPopularMovies(): Item {
        return MainCardContainer(
                ::onItemClick,
                listOf(
                        MovieItem(
                                MovieContent(
                                        IMG_URL+"30891708-1170704.jpg"
                                )
                        ),
                        MovieItem(
                                MovieContent(
                                        IMG_URL+"umbrella.jpeg"
                                )
                        ),
                        MovieItem(
                                MovieContent(
                                        IMG_URL+"30891708-1170704.jpg"
                                )
                        ),
                        MovieItem(
                                MovieContent(
                                        IMG_URL+"kinopoisk.ru-Memoriseuteu-3483691.jpg"
                                )
                        ),
                        MovieItem(
                                MovieContent(
                                        "https://upload.wikimedia.org/wikipedia/ru/8/8a/Fight_club.jpg"
                                )
                        )
                )
        )
    }

    fun onItemClick(url: String) {
    }
}