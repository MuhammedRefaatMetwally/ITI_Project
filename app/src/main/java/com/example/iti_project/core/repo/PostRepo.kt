package com.example.iti_project.core.repo

import com.example.iti_project.core.data_source.remote_data_source.RetrofitClient
import com.example.iti_project.core.model.Post
import retrofit2.Response

class PostRepo {

    val retrofit = RetrofitClient.getInstance("https://jsonplaceholder.typicode.com/")


    suspend fun getPost(userId : Int) : Response<List<Post>>{
       return retrofit.getPosts(userId)
    }
}