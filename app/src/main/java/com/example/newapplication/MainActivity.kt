package com.example.newapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListeners()
        setOnFocusChangeListeners()


    }

   private fun setOnClickListeners() {
        singUpOnClickListener()
        setLoginClickListener()
    }

   private fun singUpOnClickListener() {
        binding.signUpTextView.setOnClickListener {
            val intent = Intent(this@MainActivity, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

   private fun setLoginClickListener() {
        binding.loginButton.setOnClickListener {
            checkPassword()
            checkEmail()
        }
    }

   private fun setOnFocusChangeListeners() {
        setPasswordFocusChangeListener()
        setMailFocusChangeListener()
    }

   private fun setPasswordFocusChangeListener() {
        binding.passwordEditText.setOnFocusChangeListener { view, hasFocus ->
            if (!hasFocus) {
                checkPassword()
            }
        }
    }

   private fun setMailFocusChangeListener() {
        binding.mailEditText.setOnFocusChangeListener { view, hasFocus ->
            if (!hasFocus) {
                checkEmail()
            }
        }
    }

   private fun checkEmail() {
        val mail = binding.mailEditText.text.toString()
        if (!mail.contains('@')) {
            binding.mailEditText.error = "Lütfen geçerli bir e-posta adresi giriniz."
        }
    }

   private fun checkPassword() {
        val password = binding.passwordEditText.text.toString()
        if (password.length < 6) {
            binding.passwordEditText.error = "Şifreniz minimum 6 karakterli olmalıdır."
        }
    }
}
