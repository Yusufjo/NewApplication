package com.example.newapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import com.example.newapplication.databinding.ActivityMainBinding

class LogInActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListeners()
        textWatchers()
    }

    private fun setOnClickListeners() {
        singUpOnClickListener()
        setLoginClickListener()
    }

    private fun singUpOnClickListener() {
        binding.signUpTextView.setOnClickListener {
            val intent = Intent(this@LogInActivity, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setLoginClickListener() {
        binding.loginButton.setOnClickListener {
            checkPassword()
            checkEmail()
        }
    }

    private fun textWatchers(){
        mailTextWatcher()
        passwordTextWathcher()
    }

    private fun passwordTextWathcher(){
        binding.passwordEditText.doAfterTextChanged {
            checkPassword()
        }
    }

    private fun mailTextWatcher(){
        binding.mailEditText.doAfterTextChanged {
            checkEmail()
        }
    }

    private fun checkEmail() {
        val mail = binding.mailEditText.text.toString()
        if (!mail.contains('@')) {
            binding.textInputLayout.error = "Lütfen geçerli bir e-posta adresi giriniz."
        } else {
            binding.textInputLayout.error = null
        }
    }

    private fun checkPassword() {
        val password = binding.passwordEditText.text.toString()
        if (password.length < 6) {
            binding.passwordLayout.error = "Şifreniz minimum 6 karakterli olmalıdır."
        }
        else{
            binding.passwordLayout.error = null
        }
    }
}
