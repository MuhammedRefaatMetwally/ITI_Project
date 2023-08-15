package com.example.iti_project.core.data_source.remote_data_source

import com.example.iti_project.core.model.Comment
import com.example.iti_project.core.model.body.LoginBodyResponse
import com.example.iti_project.core.model.Post
import com.example.iti_project.core.model.response.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("posts")
    suspend fun getPosts(@Query("userId") userId : Int) : Response<List<Post>>

    @GET("post/{post_id}/comments")
    suspend fun getComments(@Path("post_id") postId : Int) : Response<List<Comment>>

    @POST("auth/login")
    suspend fun login(@Body body : LoginBodyResponse) : Response<UserResponse>
}