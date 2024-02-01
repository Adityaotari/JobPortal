package com.example.jobportal.recruiter.addposts.repository

import com.example.jobportal.commons.repository.Repository
import com.example.jobportal.recruiter.addposts.models.AddJobPostSkillsModel

class AddJobPostSkillsRepository: Repository() {
    fun addpostskills(
        post: AddJobPostSkillsModel
    ):Boolean{
        return true
    }
}