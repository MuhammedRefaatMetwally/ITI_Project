package com.example.iti_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.iti_project.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val emailText = binding.editTextLogin.text

        binding.loginButton.setOnClickListener {
            if (emailText.isNotEmpty()) {
                Toast.makeText(this@MainActivity, R.string.login_success, Toast.LENGTH_LONG).show()
                println(emailText.toString())
            }else{
                 Toast.makeText(this@MainActivity, R.string.login_failed, Toast.LENGTH_LONG).show()
            }

        }
    }

}