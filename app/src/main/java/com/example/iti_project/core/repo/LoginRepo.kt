package com.example.iti_project.core.repo

import android.content.Context
import com.example.iti_project.Constant
import com.example.iti_project.core.data_source.local_data_source.AppSharedReferences
import com.example.iti_project.core.data_source.remote_data_source.RetrofitClient
import com.example.iti_project.core.model.body.LoginBodyResponse
import com.example.iti_project.core.model.response.UserResponse
import retrofit2.Response

class LoginRepo {

    val retrofit = RetrofitClient.getInstance("https://dummyjson.com/")


    suspend fun  login(username : String , password : String) : Response<UserResponse>{
        saveSharedData(username,password)
       return retrofit.login(LoginBodyResponse(username,password))
    }

    private fun saveSharedData(username: String, password: String){
        AppSharedReferences.write(Constant.USER_NAME,username)
        AppSharedReferences.write(Constant.PASSWORD,password)
        AppSharedReferences.write(Constant.IS_LOGIN,true)
    }


}