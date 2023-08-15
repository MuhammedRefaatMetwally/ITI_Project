package com.example.iti_project.ui.comment
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.iti_project.core.model.Comment
import com.example.iti_project.core.repo.CommentRepo
import kotlinx.coroutines.launch
import retrofit2.Response

class CommentViewModel : ViewModel() {


     val commentLiveData : MutableLiveData<Response<List<Comment>>> = MutableLiveData()
     val commentRepo = CommentRepo()

    fun getComments(postId : Int){
        viewModelScope.launch(){
             commentLiveData.postValue(commentRepo.getComments(postId))
        }
    }
    
    
}