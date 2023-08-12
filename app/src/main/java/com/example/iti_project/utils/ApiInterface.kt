package com.example.iti_project.utils

import com.example.iti_project.model.Comment
import com.example.iti_project.model.Post
import com.example.iti_project.model.ResponseUserModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("posts")
    suspend fun getPosts(@Query("userId") userId : Int) : Response<List<Post>>

    @GET("post/{post_id}/comments")
    suspend fun getComments(@Path("post_id") postId : Int) : Response<List<Comment>>
}