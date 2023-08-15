package com.example.iti_project.core.model

import com.google.gson.annotations.SerializedName

data class Support(

    @SerializedName("url")
    val url : String ,

    @SerializedName("text")
    val text : String
){


}
