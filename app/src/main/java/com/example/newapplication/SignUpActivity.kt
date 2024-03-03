package com.example.newapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.newapplication.databinding.ActivitySignUpBinding
import com.google.android.material.snackbar.Snackbar

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
// mail control etme
        binding.editTextTextEmailAddress2.setOnFocusChangeListener { view, hasFocus ->
            if (!hasFocus) {
                val mail = binding.editTextTextEmailAddress2.text.toString()

                if (!mail.contains("@")) {
                    // @ sembolü yoksa EditText'e hata ekleyin
                    binding.editTextTextEmailAddress2.error = "Lütfen geçerli bir e-posta adresi girin"
                }

            }
        }
        //Şifrenin minimum 6 harf olması kontrolü

        binding.editTextTextPassword.setOnFocusChangeListener{ view, hasFocus ->
            if (!hasFocus) {
                val password = binding.editTextTextPassword.text.toString()
                if (password.length < 6) {
                    // @ sembolü yoksa EditText'e hata ekleyin
                    binding.editTextTextPassword.error = "Oluşturacağınız şifre minimum 6 karakterli olmalıdır."
                }

            }
        }
        // şifrelerin aynı olup olmadığının kontrolü


        binding.singUp.setOnClickListener {

                    val password2 = binding.editTextTextPassword2.text.toString()
                    val password = binding.editTextTextPassword.text.toString()
                    if (password != password2){
                        binding.editTextTextPassword2.error = "Şifreler aynı olmalıdır. Lütfen kontrol ederek tekrar deneyiniz."
                    }
                }
            }
        }

