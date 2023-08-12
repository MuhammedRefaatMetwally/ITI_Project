package com.example.myapplication


import com.example.iti_project.model.Post

interface OnItemClickListener {
    fun onClick(postItem : Post, position:Int)
}