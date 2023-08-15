package com.example.iti_project.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.iti_project.core.model.response.UserResponse
import com.example.iti_project.core.repo.LoginRepo
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginViewModel : ViewModel() {

    val loginData : MutableLiveData<Response<UserResponse>> = MutableLiveData()
    private val repo = LoginRepo()

     fun startLogin(username : String, password : String){
     viewModelScope.launch(){
         loginData.postValue( repo.login(username,password))

     }
    }

}