package com.example.iti_project.core.model.response

import com.google.gson.annotations.SerializedName

data class UserResponse(

    @SerializedName("id")
    val id : Int ,
    @SerializedName("username")
    val userName : String ,
    @SerializedName("email")
    val email : String ,
    @SerializedName("firstName")
    val firstName : String,
    @SerializedName("lastName")
    val lastName : String,
    @SerializedName("gender")
    val gender : String,
    @SerializedName("image")
    val image : String,
    @SerializedName("token")
    val token : String,
){}
