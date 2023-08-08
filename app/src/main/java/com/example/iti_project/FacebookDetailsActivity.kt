package com.example.iti_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.iti_project.databinding.ActivityFacebookDetailsBinding
import com.squareup.picasso.Picasso

class FacebookDetailsActivity : AppCompatActivity() {
    lateinit var binding : ActivityFacebookDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFacebookDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Picasso.get().load(intent.getStringExtra(Constant.POST_IMAGE)).into(binding.postImageDetail)
        binding.postName.text ="Name: ${intent.getStringExtra(Constant.POST_NAME)} "
        binding.postStatus.text ="Status: ${intent.getStringExtra(Constant.POST_STATUS)} "
    }
}