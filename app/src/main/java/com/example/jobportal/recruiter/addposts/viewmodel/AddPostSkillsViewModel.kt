package com.example.jobportal.recruiter.addposts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jobportal.recruiter.addposts.models.AddJobPostSkillsModel
import com.example.jobportal.recruiter.addposts.repository.AddJobPostSkillsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddPostSkillsViewModel(private val addJobPostSkillsRepository: AddJobPostSkillsRepository) : ViewModel() {
    val addPostMutableLiveData = MutableLiveData<Boolean>()
    fun add(
        skills : String,
    ){
        CoroutineScope(Dispatchers.IO).launch {
            val response = addJobPostSkillsRepository.addpostskills(
                AddJobPostSkillsModel(
                    skills
                )
            )
            withContext(Dispatchers.Main){
                addPostMutableLiveData.postValue(response)
            }
        }

    }    }