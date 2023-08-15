package com.example.iti_project.ui.post


import com.example.iti_project.core.model.Post

interface OnItemClickListener {
    fun onClick(postItem : Post, position:Int)
}