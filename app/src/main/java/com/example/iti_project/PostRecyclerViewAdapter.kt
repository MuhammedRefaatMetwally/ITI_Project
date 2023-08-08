package com.example.iti_project

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.iti_project.PostRecyclerViewAdapter.PostViewHolder
import com.example.iti_project.databinding.PostItemBinding
import com.example.myapplication.OnItemClickListener
import com.squareup.picasso.Picasso

class PostRecyclerViewAdapter(private val posts: List<Post>?, private val listener: OnItemClickListener) : RecyclerView.Adapter<PostViewHolder?>() {

    inner class PostViewHolder(val binding: PostItemBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = PostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }


    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val item = posts!![position]
        Picasso.get().load(item.profilePicture).into(holder.binding.profileImage)
        Picasso.get().load(item.postImage).into(holder.binding.postImage)
        holder.binding.textViewName.text = item.name
        holder.binding.textViewStatus.text = item.status
        holder.binding.textViewLastOnline.text = item.lastOnline + " hr"
        holder.binding.textViewLikes.text = item.likes
        holder.binding.postImage.setOnClickListener { listener.onClick(item,position) }
    }





    override fun getItemCount(): Int {
        return posts?.size ?: 0
    }

}