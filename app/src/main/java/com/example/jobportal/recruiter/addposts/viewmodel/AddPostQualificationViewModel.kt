package com.example.jobportal.recruiter.addposts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jobportal.recruiter.addposts.models.AddJobPostQualificationModel
import com.example.jobportal.recruiter.addposts.repository.AddJobPostQualificationRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddPostQualificationViewModel (private val addJobPostQualificationRepository: AddJobPostQualificationRepository
) : ViewModel() {
    val addPostMutableLiveData = MutableLiveData<Boolean>()

    fun add(
        image : Int,
        qualification : String,
        minimumScore : String,
        passsingYear : String,
    ){
        CoroutineScope(Dispatchers.IO).launch {
            val response = addJobPostQualificationRepository.addpostqualification(
                AddJobPostQualificationModel(
                    image,
                    qualification,
                    minimumScore,
                    passsingYear
                )
            )
            withContext(Dispatchers.Main){
                addPostMutableLiveData.postValue(response)
            }
        }

    }    }