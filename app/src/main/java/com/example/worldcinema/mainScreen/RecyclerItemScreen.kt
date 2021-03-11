package com.example.worldcinema.mainScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.worldcinema.R
import com.google.gson.GsonBuilder
import com.mrz.worldcinema.api.ApiRequest
import com.mrz.worldcinema.constants.Constants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_recycler_item_screen.*
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RecyclerItemScreen : AppCompatActivity() {

    var name: String = ""
    var description: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_item_screen)

        val idClicked:String = intent.getStringExtra("FilmId").toString()
        getMovies(idClicked)
    }

    private fun getMovies(cover:String) {
        buildNewRetrofit().create(ApiRequest::class.java).getFilm(cover).subscribeOn(
            Schedulers.newThread()
        )
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                name = it.name
                description = it.description
            }.subscribeBy(
                onNext = {
                    tvFilmNameRecyclerElement.text = name
                    Log.d("testGif", "StartFilm")
                    Toast.makeText(this, "Good", Toast.LENGTH_SHORT).show()

                }, onError = {
                    Log.e("testGif", "ErrorFilm")
                    Toast.makeText(this, "Bad Movies", Toast.LENGTH_SHORT).show()
                }
            )
    }

    fun buildNewRetrofit(): Retrofit {

        val client = OkHttpClient.Builder()
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        return retrofit

    }
}