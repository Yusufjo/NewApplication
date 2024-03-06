package com.example.newapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isInvisible
import com.example.newapplication.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnFocusListeners()
        singUpOnClickListener()
    }

    private fun singUpOnClickListener(){
        binding.singUp.setOnClickListener {
            passwordDoubleCheck()
            mailCheck()
            passwordCheck()
            progressBar()
        }
    }
    private fun setOnFocusListeners(){
        passwordSetOnFocusListener()
        mailSetOnFocusListener()
    }
    private fun passwordSetOnFocusListener(){
        binding.editTextTextPassword.setOnFocusChangeListener { view, hasFocus ->
            if (!hasFocus) {
                passwordCheck()
            }
        }
    }
    private fun mailSetOnFocusListener(){
        binding.editTextTextEmailAddress2.setOnFocusChangeListener { view, hasFocus ->
            if (!hasFocus) {
                mailCheck()
            }
        }
    }

    private fun mailCheck() {
        val mail = binding.editTextTextEmailAddress2.text.toString()
        if (!mail.contains('@')) {
            binding.editTextTextEmailAddress2.error = "Lütfen geçerli bir e-posta adresi giriniz."
        }
    }

    private fun passwordCheck() {
        val password = binding.editTextTextPassword.text.toString()
        if (password.length < 6) {
            binding.editTextTextPassword.error = "Şifreniz minimum 6 karakterli olmalıdır."
        }
    }

    private fun passwordDoubleCheck() {
        val password2 = binding.editTextTextPassword2.text.toString()
        val password = binding.editTextTextPassword.text.toString()
        if (password != password2) {
            binding.editTextTextPassword2.error =
                "Şifreler aynı olmalıdır. Lütfen kontrol ederek tekrar deneyiniz."
        }
    }
    private fun progressBar(){
        binding.singUp.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE

            Handler(Looper.getMainLooper()).postDelayed({
                binding.progressBar.visibility = View.GONE
            },2000)
            }
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setTitle("Kayıt Başarılı")
        val dialog = dialogBuilder.create()
        dialog.show()


        }
    }


