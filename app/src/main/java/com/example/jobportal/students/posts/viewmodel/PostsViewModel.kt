package com.example.jobportal.students.posts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jobportal.students.posts.models.JobsPost
import com.example.jobportal.students.posts.repository.PostsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PostsViewModel(
    private val postsRepository : PostsRepository
): ViewModel() {

    val postsUpdateAvailableLiveData = MutableLiveData<Boolean>()
    val posts = ArrayList<JobsPost>()

    fun fetchPosts(){
        CoroutineScope(Dispatchers.IO).launch {
            val posts = postsRepository.jobsPosts()

            withContext(Dispatchers.Main){
                this@PostsViewModel.posts.addAll(posts)
                postsUpdateAvailableLiveData.postValue(true)
            }
        }
    }
}