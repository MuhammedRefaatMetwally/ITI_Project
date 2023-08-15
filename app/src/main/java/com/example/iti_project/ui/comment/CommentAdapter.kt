package com.example.iti_project.ui.comment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.iti_project.core.model.Comment
import com.example.iti_project.databinding.CommentItemBinding

class CommentAdapter(val comments : List<Comment>?) : Adapter<CommentAdapter.CommentViewHolder>()  {

    inner class CommentViewHolder(val binding : CommentItemBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val binding = CommentItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  CommentViewHolder(binding)
    }

    override fun getItemCount(): Int = comments?.size ?: 0

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.binding.commentName.text = "Name:\n ${comments?.get(position)?.name ?: ""} "
        holder.binding.commentBody.text = "Body:\n ${comments?.get(position)?.body ?: ""} "
        holder.binding.commentEmail.text = "Email: ${comments?.get(position)?.email ?: ""}"
    }
}