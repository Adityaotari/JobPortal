package com.example.jobportal.auth.fragments

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

import com.bitcodetech.jobportal.databinding.ActivityLoginBinding
import com.example.jobportal.MainActivity
import com.example.jobportal.auth.repository.LogInRepository
import com.example.jobportal.auth.viewmodels.LogInViewModel
import com.example.jobportal.commons.factory.ViewModelFactory

class LoginAcitvity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var logInViewModel: LogInViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initViewsModels()
        initObservers()
        initListeners()
    }
    private fun initViewsModels(){
        logInViewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                LogInRepository(
                )
            )
        )[LogInViewModel::class.java]
    }


    private fun initObservers(){
        logInViewModel.userLogInStatusLiveData.observe(
            this,
        ){
            if (it){
                finish()
                startMainActivity()
            }
            else{

            }
        }

    }
    private fun startMainActivity(){
        startActivity(
            Intent(
                this@LoginAcitvity, MainActivity::class.java
            )
        )
    }
    private fun initListeners(){
        binding.btnLogin.setOnClickListener {
            logInViewModel.validateCredentials(
                binding.edtUserName.text.toString(),
                binding.edtPassword.text.toString()
            )
        }
    }
}
