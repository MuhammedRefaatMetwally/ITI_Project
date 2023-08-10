package com.example.iti_project

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.iti_project.PostRecyclerViewAdapter.PostViewHolder
import com.example.iti_project.databinding.PostItemBinding
import com.example.iti_project.model.Support
import com.example.iti_project.model.User
import com.squareup.picasso.Picasso

class PostRecyclerViewAdapter(private val users: List<User>? , private  val support : Support?) : RecyclerView.Adapter<PostViewHolder?>() {

    inner class PostViewHolder(val binding: PostItemBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = PostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }


    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val item = users!![position]

        Picasso.get().load(item.avatar).into(holder.binding.postImage)
        holder.binding.textViewName.text = "${item.firstName} ${item.lastName}"
        holder.binding.textViewStatus.text = item.email
        holder.binding.textViewLastOnline.text = "${item.id} hr"
        holder.binding.textViewLikes.text = "${item.id}"
        if(item.avatar.isNotEmpty() ){
            Picasso.get().load(item.avatar).into(holder.binding.profileImage)
        }

        // holder.binding.postImage.setOnClickListener { listener.onClick(item,position) }
    }





    override fun getItemCount(): Int {
        return users?.size ?: 0
    }

}