package com.example.worldcinema

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.worldcinema.common.adapter.MyAdapter
import com.mrz.apiwork.MainViewModel
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.activity_main_screen.*

class MainScreen : AppCompatActivity() {

    private val myAdapter by lazy { MyAdapter() }
    private lateinit var viewModel: MainViewModel

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


//        val repository = Repository()
//        val viewModelFactory = MainViewModelFactory(repository)
//        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
//        viewModel.getImg()
//        viewModel.myResponse.observe(this, Observer { response ->
//            if (response.isSuccessful){
//                var imgUrl = response.body()?.foregroundImage
//                Log.d("MainT", response.body()?.foregroundImage.toString())
//            } else {
//                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
//            }
//        })
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
                        "https://upload.wikimedia.org/wikipedia/en/e/e1/Joker_%282019_film%29_poster.jpg"
                    )
                ),
                MovieItem(
                    MovieContent(
                        "https://upload.wikimedia.org/wikipedia/en/4/45/Bloodshot_-_official_film_poster.jpeg"
                    )
                ),
                MovieItem(
                    MovieContent(
                        "https://upload.wikimedia.org/wikipedia/en/0/06/The_Gentlemen_poster.jpg"
                    )
                ),
                MovieItem(
                    MovieContent(
                        "https://upload.wikimedia.org/wikipedia/en/a/a4/Ford_v._Ferrari_%282019_film_poster%29.png"
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