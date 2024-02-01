package com.example.jobportal.recruiter.addposts.models

data class AddPostModel(
    val image : Int,
    val title : String,
    val jobDescription : String,
    val salary : String,
    val postedDate : String,
    val benifits : String,
    val expectedJoiningDate: String,
    val employmentType : String,
    val workMode : String,

)
