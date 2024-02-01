package com.example.jobportal.recruiter.addposts.repository

import com.example.jobportal.commons.repository.Repository
import com.example.jobportal.recruiter.addposts.models.AddJobPostQualificationModel

class AddJobPostQualificationRepository : Repository(){
    fun addpostqualification(
        post : AddJobPostQualificationModel
    ):Boolean{
        return true
    }
}