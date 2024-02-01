package com.example.jobportal.students.posts.repository

import com.example.jobportal.commons.repository.Repository
import com.example.jobportal.students.posts.models.JobsPost

class PostsRepository: Repository() {

    fun jobsPosts(): List<JobsPost>{

        val jobsPost = ArrayList<JobsPost>()



        jobsPost.add(
            JobsPost(
                "Android Developer",
                "2.4" ,
                "Bitcode",
                "Pune"
            )
        )
        jobsPost.add(
            JobsPost(
                "Java Developer",
                "3.2" ,
                "Bitcode",
                "Pune"

            )
        )
        jobsPost.add(
            JobsPost(
                "Web Developer",
                "2.4" ,
                "Bitcode",
                "Pune"

            )
        )

        return jobsPost

    }


}