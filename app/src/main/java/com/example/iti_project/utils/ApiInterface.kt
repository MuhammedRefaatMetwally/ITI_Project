package com.example.iti_project.utils

import com.example.iti_project.model.ResponseUserModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("/api/users")
    suspend fun getUser() : Response<ResponseUserModel>
}