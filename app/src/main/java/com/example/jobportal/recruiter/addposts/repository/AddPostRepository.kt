package com.example.jobportal.recruiter.addposts.repository

import com.example.jobportal.commons.repository.Repository
import com.example.jobportal.recruiter.addposts.models.AddPostModel

class AddPostRepository: Repository() {
    fun addPost(
        post : AddPostModel
    ):Boolean{
        return true
    }
}