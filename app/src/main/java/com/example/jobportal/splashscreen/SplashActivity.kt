package com.example.jobportal.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.bitcodetech.jobportal.databinding.SplashActivityBinding
import com.example.jobportal.auth.fragments.LoginAcitvity

class SplashActivity: AppCompatActivity() {
    private lateinit var binding: SplashActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SplashActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Use Handler to delay the task
        Handler().postDelayed({
            val intent = Intent(this@SplashActivity, LoginAcitvity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}