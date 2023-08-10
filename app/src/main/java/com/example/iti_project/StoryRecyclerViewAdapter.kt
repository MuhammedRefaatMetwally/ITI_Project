package com.example.iti_project

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.iti_project.databinding.StoriesItemBinding
import com.example.iti_project.model.User
import com.squareup.picasso.Picasso

class StoryRecyclerViewAdapter(var users:List<User>?) : RecyclerView.Adapter<StoryRecyclerViewAdapter.StoryViewHolder>() {

    inner class StoryViewHolder(val binding : StoriesItemBinding) : ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val binding = StoriesItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return StoryViewHolder(binding)
    }


    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
       val item = users?.get(position)
        Picasso.get().load(item?.avatar).into(holder.binding.storyImage)
    }

    override fun getItemCount(): Int = users?.size ?: 0

}
