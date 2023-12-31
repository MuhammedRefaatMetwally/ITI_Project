package com.example.iti_project.ui.login

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.iti_project.Constant
import com.example.iti_project.ui.post.PostActivity
import com.example.iti_project.R
import com.example.iti_project.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var sports = ""
    private var gender = ""
    lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = LoginViewModel()
        viewModel.loginData.observe(this){
            Toast.makeText(this,"Welcome ${it.body()?.firstName}",Toast.LENGTH_LONG).show()
        }
        val passwordText = binding.inputPassword.text
        val gamingCheckbox = binding.gamingCk
        val soccerCheckbox = binding.soccerCk
        val pingPongCheckbox = binding.pingPongCk
        val maleRadioBtn = binding.maleRadio
        val femaleRadioBtn = binding.femaleRadio
        var validateLogin = false



        binding.loginButton.setOnClickListener {
            val emailText = binding.inputUsername.text.toString()

            validateLogin = (emailText.isNotEmpty() && passwordText.isNotEmpty()) &&
                    (gamingCheckbox.isChecked || soccerCheckbox.isChecked || pingPongCheckbox.isChecked)
                    && (maleRadioBtn.isChecked || femaleRadioBtn.isChecked)
            checkOnData()

             if (validateLogin) {
                 viewModel.startLogin(binding.inputUsername.text.toString(),binding.inputPassword.text.toString())
                 navigatingToScreen()
             } else {
                 Toast.makeText(this@LoginActivity, "Fill up the Form Please!", Toast.LENGTH_LONG).show()
             }

        }

    }



    private fun checkOnData() {
        if (binding.soccerCk.isChecked) {
            sports += "Soccer - "
        }

        if (binding.gamingCk.isChecked) {
            sports += "Gaming - "
        }

        if (binding.pingPongCk.isChecked) {
            sports += "PingPong - |"
        }

        gender = if (binding.maleRadio.isChecked) {
            "Male"
        } else {
            "Female"
        }
    }

    private fun navigatingToScreen() {
        startActivity( Intent(this@LoginActivity, PostActivity::class.java))
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main_activity, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.go_to_second -> {
                startActivity(Intent(this@LoginActivity, PostActivity::class.java))
                true
            }

            R.id.exit -> {
                showExitDialog()
                true
            }
            //Search Topic
            R.id.item1 ->{
                item.isChecked = !item.isChecked
                true
            }
            R.id.item2 ->{
                item.isChecked = !item.isChecked
                true
            }
            R.id.item3 ->{
                item.isChecked = !item.isChecked
                true
            }
            R.id.item4 ->{
                item.isChecked = !item.isChecked
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private val myInterfaceForDialog = DialogInterface.OnClickListener { dialog, which ->
        when (which) {
            -1 -> finish()
            -2 -> dialog.cancel()
            else -> Toast.makeText(this, "Action Canceled", Toast.LENGTH_LONG).show()
        }
    }

    private fun showExitDialog() {
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setTitle(getString(R.string.dialog_title))
        dialogBuilder.setMessage(getString(R.string.dialog_message))
        dialogBuilder.setPositiveButton(getString(R.string.dialogn_yes), myInterfaceForDialog)
        dialogBuilder.setNegativeButton(getString(R.string.dialog_no), myInterfaceForDialog)
        dialogBuilder.setNeutralButton(getString(R.string.dialog_cancel), myInterfaceForDialog)

        val alertDialog = dialogBuilder.create()
        alertDialog.show()
    }

    @Deprecated(
        "Deprecated in Java", ReplaceWith(
            "super.onActivityResult(requestCode, resultCode, data)",
            "androidx.appcompat.app.AppCompatActivity"
        )
    )
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 3) {
            Toast.makeText(
                this@LoginActivity,
                data?.getStringExtra(Constant.LOGIN_BY),
                Toast.LENGTH_LONG
            ).show()
        } else {
            Toast.makeText(this@LoginActivity, "Not Found Error Occurred", Toast.LENGTH_LONG).show()
        }

    }



}