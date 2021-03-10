package com.mrz.apiwork

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrz.apiwork.model.Cover
import com.mrz.apiwork.model.Post
import com.mrz.apiwork.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private var repository: Repository) : ViewModel() {

    var myResponse: MutableLiveData<Response<Cover>> = MutableLiveData()
    val myCustomPosts: MutableLiveData<Response<List<Post>>> = MutableLiveData()

    //Получение одиночного элемента
    fun getImg() {
        viewModelScope.launch {
            val response = repository.getImg()
            myResponse.value = response
        }
    }

}