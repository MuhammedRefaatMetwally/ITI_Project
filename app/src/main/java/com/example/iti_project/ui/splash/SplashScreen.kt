package com.example.iti_project.ui.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.iti_project.Constant
import com.example.iti_project.R
import com.example.iti_project.core.data_source.local_data_source.AppSharedReferences
import com.example.iti_project.ui.login.LoginActivity
import com.example.iti_project.ui.post.PostActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN) // to remove status bar

        val isLogin = AppSharedReferences.read(Constant.IS_LOGIN,false)


        Handler().postDelayed({
            if(isLogin){
                startActivity(Intent(this@SplashScreen, PostActivity::class.java))
            }else{
                startActivity(Intent(this@SplashScreen, LoginActivity::class.java))

            }
            finish()
        },3000)

    }
}