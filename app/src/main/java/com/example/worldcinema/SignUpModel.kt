package com.mrz.apiwork

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrz.apiwork.model.Post
import com.mrz.apiwork.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class SignUpModel(private var repository: Repository) : ViewModel() {

    var myResponse: MutableLiveData<Response<Post>> = MutableLiveData()

    //Отправка поста
    fun register(post: Post) {
        viewModelScope.launch {
            val response = repository.register(post)
            myResponse.value = response
        }
    }

}