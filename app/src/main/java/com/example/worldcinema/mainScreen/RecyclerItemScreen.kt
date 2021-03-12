package com.example.worldcinema.mainScreen

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.MediaController
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.worldcinema.R
import com.example.worldcinema.common.adapter.EpisodesAdapter
import com.example.worldcinema.common.adapter.MyAdapter
import com.example.worldcinema.common.adapter.TagsAdapter
import com.example.worldcinema.data.EpisodesList
import com.example.worldcinema.data.Tag
import com.google.gson.GsonBuilder
import com.mrz.worldcinema.api.ApiRequest
import com.mrz.worldcinema.constants.Constants
import com.mrz.worldcinema.constants.Constants.Companion.VIDEO_URL
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main_screen.*
import kotlinx.android.synthetic.main.activity_recycler_item_screen.*
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RecyclerItemScreen : AppCompatActivity() {

    private val tagsAdapter by lazy { TagsAdapter() }
    private val episodeAdapter by lazy { EpisodesAdapter() }
    private var name: String = ""
    private var age: String = ""
    private var description: String = ""
    private lateinit var images: List<String>
    private var movieId: String = ""
    private var poster: String = ""
    private var preview: String = ""
    private var tags: List<String> = listOf("Фэнтези","Приключения")
    private lateinit var episodes: List<EpisodesList>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_item_screen)


        val idClicked:String = intent.getStringExtra("FilmId").toString()
        getMovies(idClicked)
        episodes_container.adapter = episodeAdapter
        episodes_container.layoutManager = LinearLayoutManager(this)
//
        tags_container.adapter = tagsAdapter
        tags_container.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        tags.let{
            tagsAdapter.setData(it)
        }

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        val onlineURL = Uri.parse(VIDEO_URL+"videoplayback.mp4")
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(onlineURL)
        videoView.requestFocus()
        videoView.start()

        getEpisodes()
    }

    private fun getMovies(cover:String) {
        buildNewRetrofit().create(ApiRequest::class.java).getFilm(cover).subscribeOn(
            Schedulers.newThread()
        )
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                name = it.name
                description = it.description
                poster = it.poster
                age = it.age
                tags = it.tags
            }.subscribeBy(
                onNext = {
                    if (age == "16") {
                        Glide.with(this)
                                .load(R.drawable.sixteen)
                                .into(icAge)
                    }
                    if (age == "0") {
                        Glide.with(this)
                                .load(R.drawable.nullplus)
                                .into(icAge)
                    }
                    if (age == "18") {
                        Glide.with(this)
                                .load(R.drawable.ic_age)
                                .into(icAge)
                    }
                    if (age == "12") {
                        Glide.with(this)
                                .load(R.drawable.twelve)
                                .into(icAge)
                    }
                    tags.let{
                        tagsAdapter.setData(it)
                    }
                    tvFilmNameRecyclerElement.text = name
                    textDescription.text = description
                    Log.d("testGif", "StartFilm $cover")
                    Glide.with(this)
                            .load(Constants.IMG_URL + poster)
                            .into(ivBgFilmCover)
                }, onError = {
                    Log.e("testGif", "ErrorFilm")
                    Toast.makeText(this, "Error Movies", Toast.LENGTH_SHORT).show()
                }
            )
    }

    private fun getEpisodes() {
        buildNewRetrofit().create(ApiRequest::class.java).getEpisodes().subscribeOn(
                Schedulers.newThread()
        )
                .observeOn(AndroidSchedulers.mainThread())
                .map {
                    episodes = it
                }.subscribeBy(
                        onNext = {
                            val mediaController = MediaController(this)
                            mediaController.setAnchorView(videoView)
                            videoView.setVideoURI(Uri.parse(VIDEO_URL +"videoplayback.mp4"))
                            videoView.setMediaController(mediaController)
                            videoView.requestFocus()

                            episodes.let{
                                episodeAdapter.setData(it, episodes[0].images)
                            }
                            Log.d("Images", episodes[0].images[0])
                        }, onError = {
                    Log.e("testGif", "cover")
                    Toast.makeText(this, "Error Video", Toast.LENGTH_SHORT).show()
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