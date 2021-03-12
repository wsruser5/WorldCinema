package com.example.worldcinema.mainScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.worldcinema.*
import com.example.worldcinema.common.adapter.MyAdapter
import com.example.worldcinema.data.MoviesListItem
import com.google.gson.GsonBuilder
import com.mrz.worldcinema.api.ApiRequest
import com.mrz.worldcinema.constants.Constants.Companion.BASE_URL
import com.mrz.worldcinema.constants.Constants.Companion.IMG_URL
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
    private var urlLast: String = ""
    private var nameLast: String = ""
    private lateinit var films: List<MoviesListItem>
    var idCover: String = ""
    private var idLast: String = ""

    private var filter: String = "forMe"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        val token:String = intent.getStringExtra("token").toString()

        btnTrends.setOnClickListener {
            filter = "inTrend"
            getMovies()
            underForYou.visibility = View.INVISIBLE
            underNew.visibility = View.INVISIBLE
            underTrend.visibility = View.VISIBLE
        }
        btnForYou.setOnClickListener {
            filter = "forMe"
            getMovies()
            underForYou.visibility = View.VISIBLE
            underNew.visibility = View.INVISIBLE
            underTrend.visibility = View.INVISIBLE
        }
        btnNew.setOnClickListener {
            filter = "new"
            getMovies()
            underForYou.visibility = View.INVISIBLE
            underNew.visibility = View.VISIBLE
            underTrend.visibility = View.INVISIBLE
        }

        if (filter == "inTrend") {
            underForYou.visibility = View.INVISIBLE
            underNew.visibility = View.INVISIBLE
            underTrend.visibility = View.VISIBLE
        }
        if (filter == "forMe") {
            underForYou.visibility = View.VISIBLE
            underNew.visibility = View.INVISIBLE
            underTrend.visibility = View.INVISIBLE
        }
        if (filter == "new") {
            underForYou.visibility = View.INVISIBLE
            underNew.visibility = View.VISIBLE
            underTrend.visibility = View.INVISIBLE
        }
        getMovies()
        items_container.adapter = myAdapter
        items_container.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)


        getLastVideo(token)
        getCover()
    }

    private fun getMovies() {
        buildNewRetrofit().create(ApiRequest::class.java).getMovies(filter).subscribeOn(
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
                    Log.d("testGif", movies.toString())
                    Toast.makeText(this, "Good", Toast.LENGTH_SHORT).show()
                }, onError = {
                    Toast.makeText(this, "Bad Movies", Toast.LENGTH_SHORT).show()
                }
            )
    }

    private fun getLastVideo(token:String) {
        buildNewRetrofit().create(ApiRequest::class.java).getLastVideo("lastView").subscribeOn(
            Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                urlLast = it[0].poster
                nameLast = it[0].name
                idLast = it[0].movieId
            }.subscribeBy(
                onNext = {
                    Glide.with(this)
                        .load(IMG_URL + urlLast)
                        .into(ivMainLastVideo)
                    tvMainLastVideoName.text = nameLast
                    ivMainLastVideo.setOnClickListener {
                        val intent = Intent(this, RecyclerItemScreen::class.java)
                        intent.putExtra("FilmId", idLast)
                        startActivity(intent)
                    }
                    Log.d("testGif", "LastVideo")
                    Toast.makeText(this, "LastVideo", Toast.LENGTH_SHORT).show()
                }, onError = {
                    Log.e("testGif", "LastVideoError")
                    Toast.makeText(this, "Bad LastVideoError", Toast.LENGTH_SHORT).show()
                }
            )
    }

    private fun getCover() {
        buildNewRetrofit().create(ApiRequest::class.java).getCover().subscribeOn(
            Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                url = it.backgroundImage ?: ""
                idCover = it.movieId ?: ""
            }.subscribeBy(
                onNext = {
                    Glide.with(this)
                        .load(IMG_URL+url)
                        .into(ivMain)
                    Log.d("testGif", "Succesful")
                    btnMainView.setOnClickListener {
                        val intent = Intent(this, RecyclerItemScreen::class.java)
                        intent.putExtra("FilmId", idCover)
                        startActivity(intent)
                    }
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

//    private fun loadFragment(fragment: Fragment) {
//        // load fragment
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.replace(R.id.container, fragment)
//        transaction.addToBackStack(null)
//        transaction.commit()
//    }
}