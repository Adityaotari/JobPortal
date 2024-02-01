package com.example.jobportal.commons.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jobportal.auth.repository.LogInRepository
import com.example.jobportal.auth.viewmodels.LogInViewModel
import com.example.jobportal.commons.repository.Repository
import com.example.jobportal.recruiter.addposts.repository.AddJobPostQualificationRepository
import com.example.jobportal.recruiter.addposts.repository.AddJobPostSkillsRepository
import com.example.jobportal.recruiter.addposts.repository.AddPostRepository
import com.example.jobportal.recruiter.addposts.viewmodel.AddPostQualificationViewModel
import com.example.jobportal.recruiter.addposts.viewmodel.AddPostSkillsViewModel
import com.example.jobportal.recruiter.addposts.viewmodel.AddPostViewModel
import com.example.jobportal.students.posts.repository.PostsRepository
import com.example.jobportal.students.posts.viewmodel.PostsViewModel
import java.lang.Exception

class ViewModelFactory(
    private val repository: Repository
): ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(LogInViewModel::class.java) && repository is LogInRepository) {
            return LogInViewModel(repository) as T
        }

       if (modelClass.isAssignableFrom(PostsViewModel::class.java) && repository is PostsRepository) {
            return PostsViewModel(repository) as T
        }
        if(modelClass.isAssignableFrom(AddPostViewModel::class.java) && repository is AddPostRepository) {
            return AddPostViewModel(repository) as T
        }
      if(modelClass.isAssignableFrom(AddPostQualificationViewModel::class.java) && repository is AddJobPostQualificationRepository) {
            return AddPostQualificationViewModel(repository) as T
       }
        if(modelClass.isAssignableFrom(AddPostSkillsViewModel::class.java) && repository is AddJobPostSkillsRepository) {
            return AddPostSkillsViewModel(repository) as T
        }

        throw Exception("Unable to create")
    }
}