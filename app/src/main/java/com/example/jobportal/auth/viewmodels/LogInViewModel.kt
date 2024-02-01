package com.example.jobportal.auth.viewmodels


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jobportal.auth.models.Credentials

import com.example.jobportal.auth.repository.LogInRepository
import com.example.jobportal.commons.factory.ViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LogInViewModel(
    private val logInRepository: LogInRepository
): ViewModel(){
    val userLogInStatusLiveData = MutableLiveData<Boolean>()

    fun validateCredentials(
        username: String,
        password: String
    )
    {
        CoroutineScope(Dispatchers.IO).launch {
            val response=logInRepository.validateCredentials(
                Credentials(username, password)
            )
            withContext(Dispatchers.Main){
                userLogInStatusLiveData.postValue(response)
            }
        }
    }
}
