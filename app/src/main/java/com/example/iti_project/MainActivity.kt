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

        val emailText = binding.inputUsername.text
        val passwordText = binding.inputPassword.text
        var gamingCheckbox = binding.gamingCk
        var soccerCheckbox = binding.soccerCk
        var pingPongCheckbox = binding.pingPongCk
        val maleRadioBtn = binding.maleRadio
        val femaleRadioBtn = binding.femaleRadio
        var conditionToLogin = false
        var gamingCheck = false
        var gamingSoccerChecked = false


        binding.loginButton.setOnClickListener {
            conditionToLogin = (emailText.isNotEmpty() &&  passwordText.isNotEmpty() &&
                    (gamingCheckbox.isChecked || soccerCheckbox.isChecked || pingPongCheckbox.isChecked))
                    && (maleRadioBtn.isChecked || femaleRadioBtn.isChecked)
            gamingCheck = gamingCheckbox.isChecked && !soccerCheckbox.isChecked && !pingPongCheckbox.isChecked
            gamingSoccerChecked = gamingCheckbox.isChecked && soccerCheckbox.isChecked && !pingPongCheckbox.isChecked

            if (conditionToLogin) {
                if(maleRadioBtn.isChecked){
                    if(gamingCheck){
                        Toast.makeText(this@MainActivity,"Welcome $emailText, Sports: ${gamingCheckbox.text} - Gender: ${maleRadioBtn.text}", Toast.LENGTH_LONG).show()
                    }else if (gamingSoccerChecked){
                        Toast.makeText(this@MainActivity,"Welcome $emailText , Sports: ${gamingCheckbox.text} -${soccerCheckbox.text} -  Gender: ${maleRadioBtn.text}", Toast.LENGTH_LONG).show()
                    }

                        Toast.makeText(this@MainActivity,"Welcome $emailText , Sports: ${gamingCheckbox.text} -${soccerCheckbox.text} - ${pingPongCheckbox.text} -  Gender: ${maleRadioBtn.text}", Toast.LENGTH_LONG).show()
                }else{
                    if(gamingCheck){
                        Toast.makeText(this@MainActivity,"Welcome $emailText , Sports: ${gamingCheckbox.text} - Gender: ${femaleRadioBtn.text}", Toast.LENGTH_LONG).show()
                    }else if (gamingSoccerChecked){
                        Toast.makeText(this@MainActivity,"Welcome $emailText , Sports: ${gamingCheckbox.text} -${soccerCheckbox.text} - Gender:  ${femaleRadioBtn.text}", Toast.LENGTH_LONG).show()
                    }

                    Toast.makeText(this@MainActivity,"Welcome $emailText , Sports: ${gamingCheckbox.text} -${soccerCheckbox.text} - ${pingPongCheckbox.text} -  Gender: ${femaleRadioBtn.text}", Toast.LENGTH_LONG).show()
                }

            }else{
                 Toast.makeText(this@MainActivity, R.string.login_failed, Toast.LENGTH_LONG).show()
            }

        }
    }

}