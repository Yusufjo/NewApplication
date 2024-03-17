package com.example.newapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.doAfterTextChanged
import com.example.newapplication.databinding.ActivityMainBinding
import com.example.newapplication.databinding.DialogNegativeBinding

class LogInActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setOnClickListeners()
        textWatchers()
    }

    private fun profileController(): Boolean {
        val mail = "yusuf@gmail.com"
        val password = "123456"

        val enteredMail = binding.mailEditText.text.toString()
        val enteredPassword = binding.passwordEditText.text.toString()
        if (mail == enteredMail && password == enteredPassword) {
            return true
        }
        return false
    }

    private fun setOnClickListeners() {
        singUpOnClickListener()
        setLoginClickListener()
        loginOnClickListener()

    }

    private fun singUpOnClickListener() {
        binding.signUpTextView.setOnClickListener {
            val intent = Intent(this@LogInActivity, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loginOnClickListener() {

        binding.loginButton.setOnClickListener {
            if (profileController()) {
                val intent = Intent(this@LogInActivity, HomePageActivity::class.java)
                startActivity(intent)
            } else {
                negativeDialog()
            }
        }
    }

    private fun negativeDialog() {
        val alertDialogBuilder = AlertDialog.Builder(this)
        val negativeBinding = DialogNegativeBinding.inflate(layoutInflater)
        alertDialogBuilder.setView(negativeBinding.root)
        val alertDialog = alertDialogBuilder.create()
        alertDialog.window?.setBackgroundDrawableResource(R.drawable.bg_rounded)
        negativeBinding.textViewDetails.text =
            "Giriş sağlayabilmek için lütfen doğru bilgileri giriniz"
        alertDialog.show()
        negativeBinding.button2.setOnClickListener {
            alertDialog.dismiss()
        }
    }

    private fun setLoginClickListener() {
        binding.loginButton.setOnClickListener {
            checkPassword()
            checkEmail()
        }
    }

    private fun textWatchers() {
        mailTextWatcher()
        passwordTextWathcher()
    }

    private fun passwordTextWathcher() {
        binding.passwordEditText.doAfterTextChanged {
            checkPassword()
        }
    }

    private fun mailTextWatcher() {
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
        } else {
            binding.passwordLayout.error = null
        }
    }
}
