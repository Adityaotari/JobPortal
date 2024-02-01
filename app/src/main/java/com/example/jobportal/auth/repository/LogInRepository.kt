package com.example.jobportal.auth.repository

import com.example.jobportal.auth.models.Credentials
import com.example.jobportal.commons.repository.Repository

class LogInRepository() : Repository() {
    fun validateCredentials(
        credentials: Credentials
    ):Boolean{
        return true
    }
}