package com.example.iti_project.model

import com.google.gson.annotations.SerializedName

data class ResponseUserModel(

    @SerializedName("page")
    val page : Int ,

    @SerializedName("per_page")
    val perPage : Int ,

    @SerializedName("total")
    val total : Int ,

    @SerializedName("total_pages")
    val total_pages : Int ,

    @SerializedName("data")
    val data : List<User> ,

    @SerializedName("support")
    val support : Support

    ){

}
