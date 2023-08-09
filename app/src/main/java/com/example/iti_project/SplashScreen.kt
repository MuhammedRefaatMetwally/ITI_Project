package com.example.iti_project

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import java.util.Timer
import java.util.TimerTask

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN) // to remove status bar

        val pref = applicationContext.getSharedPreferences("MyData" , Context.MODE_PRIVATE)
        val isLogin = pref.getBoolean("IS_LOGIN",false)


        Handler().postDelayed({
            if(isLogin){
                startActivity(Intent(this@SplashScreen, FacebookActivity::class.java))
            }else{
                startActivity(Intent(this@SplashScreen, MainActivity::class.java))

            }
            finish()
        },3000)

    }
}