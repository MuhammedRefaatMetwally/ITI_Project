package com.example.iti_project

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
import com.example.iti_project.databinding.ActivityFacebookMainBinding
import com.example.iti_project.model.Support
import com.example.iti_project.model.User
import com.example.iti_project.utils.ApiInterface
import com.example.iti_project.utils.RetrofitClient
import com.example.myapplication.OnItemClickListener
import kotlinx.coroutines.launch

class FacebookActivity : AppCompatActivity() , OnItemClickListener {
    lateinit var sharedPref :SharedPreferences
    lateinit var binding: ActivityFacebookMainBinding
    private lateinit var recyclerViewPosts: RecyclerView
    private lateinit var recyclerViewStories: RecyclerView
    private lateinit var postAdapter: PostRecyclerViewAdapter
    private lateinit var storyAdapter: StoryRecyclerViewAdapter
    private lateinit var posts: MutableList<Post>
    private lateinit var stories: MutableList<Story>
    private  var users : List<User>? = null
    private  var support: Support? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFacebookMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerViewSetup()
        sharedPref =
            applicationContext.getSharedPreferences("MyData", Context.MODE_PRIVATE)

        binding.logoutIcon2.setOnClickListener {
            val editor = sharedPref.edit()
            editor.putBoolean("IS_LOGIN", false)
            editor.remove("USER_NAME")
            editor.remove("PASSWORD")
            editor.commit()
            Log.e("error", "${sharedPref.getBoolean("IS_LOGIN", false)}")
            Log.e("error", "${sharedPref.getString("USER_NAME", "UNKNOWN")}")
            startActivity(Intent(this@FacebookActivity, MainActivity::class.java))
            finish()
        }

        binding.txtStories.text = "Welcome! ${sharedPref.getString("USER_NAME", "UNKNOWN")}"



    }

    private fun recyclerViewSetup() {
        //createPostList()
        //createStoryList()
        users = getUserList()
        support = getSupport()
        recyclerViewPosts = binding.rvPosts
        recyclerViewStories = binding.storiesRv

    }
    private  fun getUserList() : List<User>? {

        val retrofit  = RetrofitClient.getInstance().create(ApiInterface::class.java)
        lifecycleScope.launch {
            val response = retrofit.getUser()
            if(response.isSuccessful){
                users = response.body()?.data
                postAdapter = PostRecyclerViewAdapter(users,support)
                recyclerViewPosts.adapter = postAdapter
                storyAdapter = StoryRecyclerViewAdapter(users)
                recyclerViewStories.adapter = storyAdapter

                users?.get(0)?.let { Log.e("error", it.firstName) }
            }else{
                Toast.makeText(this@FacebookActivity,"No Data" ,Toast.LENGTH_LONG).show()
            }
        }
        return users
    }

    private  fun getSupport() : Support? {
        val retrofit  = RetrofitClient.getInstance().create(ApiInterface::class.java)
        lifecycleScope.launch {
            val response = retrofit.getUser()
            if(response.isSuccessful){
                support = response.body()?.support
                postAdapter = PostRecyclerViewAdapter(users,support)
            }else{
                Toast.makeText(this@FacebookActivity,"No Data" ,Toast.LENGTH_LONG).show()
            }
        }
        return support
    }

    private fun createPostList() {
        posts = mutableListOf()
        posts.add(
            Post(
                "Night Dark",
                "https://images.unsplash.com/photo-1511367461989-f85a21fda167?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8cHJvZmlsZXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80",
                "This is my First Post in RecyclerView , Very Proud of My work Thanks Route!!",
                "https://static.vecteezy.com/system/resources/previews/022/448/291/original/save-earth-day-poster-environment-day-nature-green-ai-generative-glossy-background-images-tree-and-water-free-photo.jpg",
                "2",
                "200"
            )
        )

        posts.add(
            Post(
                "Cat Cool",
                "https://wallpapers.com/images/hd/cool-profile-picture-1ecoo30f26bkr14o.jpg",
                "How Cool is this RecyclerView , Sounds Interesting !!",
                "https://cdn.pixabay.com/photo/2018/01/14/23/12/nature-3082832_640.jpg",
                "5",
                "160"
            )
        )
        posts.add(
            Post(
                "Animation Boy",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTI8jrI5YalR4CDz25yNrKDKq38oBehnbuuFQficzZdQfdEq9e_U5xnFLO54bNVi55VpZ0&usqp=CAU",
                "RecyclerView is so Easy rn , What is Now ?! Nothing new ?!!",
                "https://t4.ftcdn.net/jpg/05/31/72/39/360_F_531723970_H1BPCO1V4zHNer9TvMw5mRQH1aMiOGNO.jpg",
                "8",
                "80"
            )
        )
        posts.add(
            Post(
                "Jetpack Composer",
                "https://images.unsplash.com/photo-1529665253569-6d01c0eaf7b6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8cHJvZmlsZXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80",
                "Can't WAIT TO BE AN AWESOME ANDROID DEVELOPER SOOOOOOOON!",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTNjvBSls5zO7SlB1JJ-agUb_XIp7zwetlIvQ&usqp=CAU",
                "3",
                "90"
            )
        )
        for (i in 0..199) {
            posts.add(
                Post(
                    "Anonymous",
                    "https://static.vecteezy.com/system/resources/thumbnails/009/209/212/small/neon-glowing-profile-icon-3d-illustration-vector.jpg",
                    "DummmmmmmmmmmmmmmmY DATAAAAAAAAAA !!",
                    "https://wallpapers.com/images/featured/outer-space-3pae4flbryaputyl.jpg",
                    (i * 2).toString() + "",
                    (i * 30).toString() + ""
                )
            )
        }
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
        val intent = Intent(this@FacebookActivity, FacebookDetailsActivity::class.java)
        intent.putExtra("post_image", postItem.postImage)
        intent.putExtra("post_name", postItem.name)
        intent.putExtra("post_status", postItem.status)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.second_main_activity, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout_menu -> {
                val editor = sharedPref.edit()
                editor.putBoolean("IS_LOGIN", false)
                editor.remove("USER_NAME")
                editor.remove("PASSWORD")
                editor.commit()
                Log.e("error", "${sharedPref.getBoolean("IS_LOGIN", false)}")
                Log.e("error", "${sharedPref.getString("USER_NAME", "UNKNOWN")}")
                startActivity(Intent(this@FacebookActivity, MainActivity::class.java))
                finish()
                true
            }

            else -> {
                super.onOptionsItemSelected(item)
            }

        }

    }

}