package com.example.iti_project.core.model

import java.io.Serializable

data class Comment(
    val postId : Int ,
    val id : Int,
    val name : String,
    val email : String,
    val body : String

):Serializable{

}
