package com.example.worldcinema.mainScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.worldcinema.*
import com.example.worldcinema.common.adapter.MyAdapter
import com.example.worldcinema.data.MoviesList
import com.example.worldcinema.data.MoviesListItem
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
    private lateinit var films: List<MoviesListItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

//        val movies = listOf(
//            getPopularMovies("poster.jpg")
//        )
        items_container.adapter = myAdapter
        items_container.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)

        getMovies()

        getCover()
    }

    private fun getMovies() {
        buildNewRetrofit().create(ApiRequest::class.java).getMovies("new").subscribeOn(
            Schedulers.newThread()
        )
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                films = it
            }.subscribeBy(
                onNext = {
                    val movies = films

                    movies.let{
                        myAdapter.setData(it)
                    }
//                    items_container.adapter = GroupAdapter<GroupieViewHolder>().apply { addAll(movies(poster))
                    Log.d("testGif", movies.toString())
                    Toast.makeText(this, "Good", Toast.LENGTH_SHORT).show()


                }, onError = {
                    Log.e("testGif", "onError url = $films")
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
                }, onError = {
                    Log.d("testGif", "onError url = $url")
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

    private fun getPopularMovies(movieIdUrl: String, list: MoviesList): Item {
        return MainCardContainer(
                ::onItemClick,
                listOf(
                        MovieItem(
                                list
                        )
                )
        )
    }

    fun onItemClick(url: String) {
        Toast.makeText(this, "I", Toast.LENGTH_SHORT).show()
        val i = Intent(this, RecyclerItemScreen::class.java)
        startActivity(i)
    }

//    private fun loadFragment(fragment: Fragment) {
//        // load fragment
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.replace(R.id.container, fragment)
//        transaction.addToBackStack(null)
//        transaction.commit()
//    }
}