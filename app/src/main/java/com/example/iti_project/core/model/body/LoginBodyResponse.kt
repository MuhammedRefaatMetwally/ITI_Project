package com.example.iti_project.core.model.body

import com.google.gson.annotations.SerializedName

data class LoginBodyResponse(
    @SerializedName("username")
    val userName : String ,
    @SerializedName("password")
    val password : String

){

}
