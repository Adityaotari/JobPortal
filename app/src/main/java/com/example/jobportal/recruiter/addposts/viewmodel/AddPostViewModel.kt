package com.example.jobportal.recruiter.addposts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jobportal.recruiter.addposts.models.AddPostModel
import com.example.jobportal.recruiter.addposts.repository.AddPostRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddPostViewModel(private val addPostRepository: AddPostRepository
) : ViewModel() {
    val addPostMutableLiveData = MutableLiveData<Boolean>()

    fun addPost(

        image : Int,
        title : String,
        jobDescription : String,
        salary : String,
        postedDate : String,
        benifits : String,
        expectedJoiningDate: String,
        employmentType : String,
        workMode : String,)
    {
        CoroutineScope(Dispatchers.IO).launch {
            val response = addPostRepository.addPost(
                AddPostModel(
                    image ,
                    title,
                    jobDescription,
                    salary,
                    postedDate,
                    benifits ,
                    expectedJoiningDate,
                    employmentType ,
                    workMode
                )
            )
            withContext(Dispatchers.Main){
                addPostMutableLiveData.postValue(response)
            }
        }

    }    }