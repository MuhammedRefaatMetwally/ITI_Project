package com.example.iti_project.ui.post

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.iti_project.core.model.Post
import com.example.iti_project.core.repo.PostRepo
import kotlinx.coroutines.launch
import retrofit2.Response

class PostViewModel : ViewModel(){

    val postLiveData : MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val repo = PostRepo()

    fun getPosts(userId : Int){
        viewModelScope.launch(){
            postLiveData.postValue(repo.getPost(userId))
        }
    }
}