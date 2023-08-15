package com.example.iti_project.ui.post

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.iti_project.Constant
import com.example.iti_project.ui.comment.CommentActivity
import com.example.iti_project.R
import com.example.iti_project.core.data_source.local_data_source.AppSharedReferences
import com.example.iti_project.ui.post.story.Story
import com.example.iti_project.ui.post.story.StoryRecyclerViewAdapter
import com.example.iti_project.databinding.ActivityFacebookMainBinding
import com.example.iti_project.core.model.Comment
import com.example.iti_project.core.model.Post
import com.example.iti_project.core.data_source.remote_data_source.RetrofitClient
import com.example.iti_project.ui.login.LoginActivity
import kotlinx.coroutines.launch

class PostActivity : AppCompatActivity() , OnItemClickListener {
    lateinit var binding: ActivityFacebookMainBinding
    private lateinit var recyclerViewPosts: RecyclerView
    private lateinit var recyclerViewStories: RecyclerView
    private lateinit var postAdapter: PostRecyclerViewAdapter
    private lateinit var storyAdapter: StoryRecyclerViewAdapter
    private lateinit var stories: MutableList<Story>
    private  var postList : List<Post>? = null
    lateinit var  viewModel: PostViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFacebookMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerViewSetup()

        viewModel.postLiveData.observe(this){
            Toast.makeText(this,"Getting Datta ", Toast.LENGTH_LONG).show()
            if(it.isSuccessful){
                postList = it.body() ?: listOf()
                postAdapter = PostRecyclerViewAdapter(postList,this@PostActivity)
                recyclerViewPosts.adapter = postAdapter
            }else{
                Toast.makeText(this@PostActivity,"No Data" ,Toast.LENGTH_LONG).show()
            }

        }

        binding.logoutIcon2.setOnClickListener {
            saveData()
            startActivity(Intent(this@PostActivity, LoginActivity::class.java))
            finish()
        }


      binding.getDataBtn.setOnClickListener {

      viewModel.getPosts(binding.editTextPostId.text.toString().toInt())

      }

    }

    private fun recyclerViewSetup() {
        viewModel = PostViewModel()
        createStoryList()
        recyclerViewPosts = binding.rvPosts
        recyclerViewStories = binding.storiesRv
        storyAdapter = StoryRecyclerViewAdapter(stories)
        recyclerViewStories.adapter = storyAdapter

    }


    private fun createStoryList() {
        stories = mutableListOf()
        stories.add(
            Story("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQP-40Y8epxpgKB1A6OAK5PKWemRaqnosaxow&usqp=CAU")
        )
        stories.add(
            Story("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR5PFLf3c23hMPhLE_WTfRMMteDaDGhlGsp0Q&usqp=CAU")
        )

        stories.add(
            Story("https://img.freepik.com/premium-vector/beautiful-cosmic-outer-space-background-wallpaper-illustration_622471-107.jpg")
        )

        stories.add(
            Story("https://i.ytimg.com/vi/eTD0WWFIDAg/maxresdefault.jpg?sqp=-oaymwEmCIAKENAF8quKqQMa8AEB-AH-DoACuAiKAgwIABABGEogEyh_MA8=&rs=AOn4CLC6GUDYzPWHrL3OW3hv3NQ58mMV5A")
        )

        for (i in 0..199) {
            stories.add(
                Story("https://c4.wallpaperflare.com/wallpaper/694/865/147/space-art-fantasy-art-sky-clouds-wallpaper-preview.jpg")
            )
        }
    }

    override fun onClick(postItem: Post, position: Int) {
        val intent = Intent(this@PostActivity, CommentActivity::class.java)
        intent.putExtra(Constant.POST_ID,postItem.id )
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.second_main_activity, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout_menu -> {
                saveData()
                startActivity(Intent(this@PostActivity, LoginActivity::class.java))
                finish()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }

        }

    }

    private fun saveData(){
        AppSharedReferences.write(Constant.IS_LOGIN,false)
        AppSharedReferences.remove(Constant.USER_NAME)
        AppSharedReferences.remove(Constant.PASSWORD)
    }



}