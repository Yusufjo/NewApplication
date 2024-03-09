package com.example.newapplication

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.example.newapplication.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private val handler = Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        singUpOnClickListener()
        setTextWatchers()

    }

    private fun singUpOnClickListener() {
        binding.singUp.setOnClickListener {
            mailCheck()
            passwordCheck()
            passwordDoubleCheck()
            showProgressBar()
        }
    }


    private fun mailCheck() {
        val mail = binding.editTextTextEmailAddress2.text.toString()
        if (!mail.contains('@')) {
            binding.textInputLayout.error = "Lütfen geçerli bir e-posta adresi giriniz."
        } else {
            binding.textInputLayout.error = null
        }
    }

    private fun passwordCheck() {
        val password = binding.editTextTextPassword.text.toString()
        if (password.length < 6) {
            binding.passwordEditText.error = "Şifreniz minimum 6 karakterli olmalıdır."
        } else {
            binding.passwordEditText.error = null
        }
    }

    private fun passwordDoubleCheck() {
        val password2 = binding.editTextTextPassword2.text.toString()
        val password = binding.editTextTextPassword.text.toString()
        if (password != password2) {
            binding.passwordEditTextConfirm.error =
                "Şifreler aynı olmalıdır. Lütfen kontrol ederek tekrar deneyiniz."
        } else {
            binding.passwordEditTextConfirm.error = null
        }
    }

    private fun setTextWatchers() {
        mailTextWatcher()
        passwordTextWatcher()
        confirmPasswordTextWatcher()
    }

    private fun passwordTextWatcher() {
        binding.editTextTextPassword.doAfterTextChanged {
            passwordCheck()
        }
    }

    private fun mailTextWatcher() {
        binding.editTextTextEmailAddress2.doAfterTextChanged {
            mailCheck()
        }
    }

    private fun confirmPasswordTextWatcher() {
        binding.editTextTextPassword2.doAfterTextChanged {
            passwordDoubleCheck()
        }
    }

    private fun showProgressBar() {
        binding.singUp.setOnClickListener {
            val mail = binding.editTextTextEmailAddress2.text.toString()
            val password = binding.editTextTextPassword.text.toString()
            val password2 = binding.editTextTextPassword2.text.toString()
            if (mail.contains('@') && password.length >= 6 && password == password2) {
                binding.progressBar.visibility = View.VISIBLE

                handler.postDelayed({
                    binding.progressBar.visibility = View.GONE
                }, 2000)

                val dialogBuilder = AlertDialog.Builder(this)
                dialogBuilder.setMessage("Kayıt Başarılı")

                val dialog = dialogBuilder.create()
                handler.postDelayed({
                    dialog.dismiss()
                    dialog.show()
                }, 2000)
            }
        }
    }

}




