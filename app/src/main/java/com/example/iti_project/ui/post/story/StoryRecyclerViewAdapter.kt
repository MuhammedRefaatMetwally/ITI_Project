package com.example.iti_project.ui.post.story

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.iti_project.databinding.StoriesItemBinding
import com.squareup.picasso.Picasso

class StoryRecyclerViewAdapter(var stories:List<Story>?) : RecyclerView.Adapter<StoryRecyclerViewAdapter.StoryViewHolder>() {

    inner class StoryViewHolder(val binding : StoriesItemBinding) : ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val binding = StoriesItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return StoryViewHolder(binding)
    }


    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
       val item = stories?.get(position)
        Picasso.get().load(item?.Image).into(holder.binding.storyImage)
    }

    override fun getItemCount(): Int = stories?.size ?: 0

}
