package com.example.iti_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.iti_project.databinding.ActivityFacebookDetailsBinding
import com.example.iti_project.model.Comment
import com.example.iti_project.model.CommentAdapter
import com.example.iti_project.utils.RetrofitClient
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch

class FacebookDetailsActivity : AppCompatActivity() {
    lateinit var binding : ActivityFacebookDetailsBinding
    lateinit var comments : List<Comment>
    lateinit var adapter : CommentAdapter
     private var postId : Int? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFacebookDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        postId = intent.getIntExtra("post_id",0)
        val retrofit  = RetrofitClient.getInstance()
        lifecycleScope.launch {
            val response = retrofit.getComments(postId!!)
            if(response.isSuccessful){
                comments = response.body() ?: listOf()
                adapter = CommentAdapter(comments)
                binding.commentsRv.adapter =adapter
            }else{
                Toast.makeText(this@FacebookDetailsActivity,"No Data" , Toast.LENGTH_LONG).show()
            }
        }

    }
    private  fun getComments( postId : Int) : List<Comment> {

        val retrofit  = RetrofitClient.getInstance()
        lifecycleScope.launch {
            val response = retrofit.getComments(postId)
            if(response.isSuccessful){
                comments = response.body() ?: listOf()
                adapter = CommentAdapter(comments)
                binding.commentsRv.adapter =adapter
            }else{
                Toast.makeText(this@FacebookDetailsActivity,"No Data" , Toast.LENGTH_LONG).show()
            }
        }
        return comments
    }

}