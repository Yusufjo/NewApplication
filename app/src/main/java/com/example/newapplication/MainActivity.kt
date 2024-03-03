package com.example.newapplication

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.newapplication.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//SignUp geçiş
        binding.signUpTextView.setOnClickListener {
            val intent = Intent(this@MainActivity, SignUpActivity::class.java)
            startActivity(intent)
        }

//          Mail için @ kontrolü
        binding.mailEditText.setOnFocusChangeListener { view, hasFocus ->
            if (!hasFocus) {
                val mail = binding.mailEditText.text.toString()

                if (!mail.contains('@')) {
                    binding.mailEditText.error = "Lütfen geçerli bir e-posta adresi giriniz."
                }

            }
        }// Şifrenin minimum 6 karekterli olup olmadığı kontrol edildi.
        binding.passwordEditText.setOnFocusChangeListener { view, hasFocus ->
            if (!hasFocus) {
                val password = binding.passwordEditText.text.toString()
                if (password.length < 6) {
                    binding.passwordEditText.error = "Şifreniz minimum 6 karakterli olmalıdır."
                }
            }
        }
        // Login butonuna tıklandığında tekrarlanan hata
        binding.loginButton.setOnClickListener {
            val password = binding.passwordEditText.text.toString()
            val mail = binding.mailEditText.text.toString()
            if (password.length < 6 || !mail.contains('@'))
                Snackbar.make(
                    it,
                    "Mail ya da şifreniz hatalıdır. Lütfen tekrar kontrol ediniz.",
                    Snackbar.LENGTH_SHORT
                ).setBackgroundTint(ContextCompat.getColor(this, R.color.login))
                    .setTextColor(Color.WHITE).show()

            // Şifrenin minimum 6 karekterli olup olmadığı kontrol edildi.
            if (password.length < 6) {
                binding.passwordEditText.error = "Şifreniz minimum 6 karakterli olmalıdır."
            }


        }
    }}
