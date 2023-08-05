package com.example.iti_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.iti_project.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding
    private lateinit var myTextUsername: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myTextUsername = binding.usernameTv
        getDataThenDisplay()

        binding.loginByButton.setOnClickListener {
            if (binding.radioGoogle.isChecked || binding.radioFacebook.isChecked) {
                returnResult()
            } else {
                Toast.makeText(
                    this@SecondActivity,
                    "Please Select The way you want to Login BY!!",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    private fun getDataThenDisplay() {
        val username = intent.getStringExtra(Constant.USER_NAME)
        val sports = intent.getStringExtra(Constant.SPORTS)
        val gender = intent.getStringExtra(Constant.GENDER)

        myTextUsername.text = username

        Toast.makeText(
            this,
            "Hello $username you like $sports and you are $gender :) ",
            Toast.LENGTH_LONG
        ).show()
    }


    private fun returnResult() {
        val loginBy = if (binding.radioGoogle.isChecked) {
            "Welcome To Google ${myTextUsername.text} !"
        } else {
            "Welcome To Facebook ${myTextUsername.text} !"
        }
        val intent = Intent()
        intent.putExtra(Constant.LOGIN_BY, loginBy)
        setResult(1, intent)

        finish()
    }

}