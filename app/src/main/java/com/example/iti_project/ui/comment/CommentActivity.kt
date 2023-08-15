package com.example.iti_project.ui.comment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.iti_project.Constant
import com.example.iti_project.databinding.ActivityFacebookDetailsBinding
import com.example.iti_project.core.model.Comment
import com.example.iti_project.core.data_source.remote_data_source.RetrofitClient
import kotlinx.coroutines.launch

class CommentActivity : AppCompatActivity() {
    
    lateinit var binding : ActivityFacebookDetailsBinding
     var comments : List<Comment>? = null
    lateinit var adapter : CommentAdapter
     private var postId : Int? =null
    lateinit var viewModel: CommentViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFacebookDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = CommentViewModel()
        postId = intent.getIntExtra(Constant.POST_ID,0)

        viewModel.commentLiveData.observe(this){
            Toast.makeText(this,"Getting Comments",Toast.LENGTH_LONG).show()
            if(it.isSuccessful){
             comments = it.body() ?: listOf()
                adapter = CommentAdapter(comments)
                binding.commentsRv.adapter = adapter
            }else{
                Toast.makeText(this,"Cant Get Data" , Toast.LENGTH_LONG).show()
            }
        }

        viewModel.getComments(postId ?: 1)
        }

    }
