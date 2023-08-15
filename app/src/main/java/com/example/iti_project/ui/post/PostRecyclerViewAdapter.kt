package com.example.iti_project.ui.post

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.iti_project.ui.post.PostRecyclerViewAdapter.PostViewHolder
import com.example.iti_project.databinding.PostItemBinding
import com.example.iti_project.core.model.Post

class PostRecyclerViewAdapter(private val posts: List<Post>?, val listener: OnItemClickListener) : RecyclerView.Adapter<PostViewHolder?>() {

    inner class PostViewHolder(val binding: PostItemBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = PostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }


    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val item = posts!![position]

        holder.binding.textViewName.text = "${item.userId} "
        holder.binding.textViewStatus.text = item.body
        holder.binding.textViewLastOnline.text = "${item.title}"
        holder.binding.textViewLikes.text = "${item.id}"


        holder.binding.postImage.setOnClickListener { listener.onClick(item,position) }
    }





    override fun getItemCount(): Int {
        return posts?.size ?: 0
    }

}