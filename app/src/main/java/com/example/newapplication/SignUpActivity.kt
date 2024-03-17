package com.example.newapplication

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.example.newapplication.databinding.ActivitySignUpBinding
import com.example.newapplication.databinding.DialogLayoutBinding
import com.example.newapplication.databinding.DialogNegativeBinding
import kotlin.random.Random

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private val handler = Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        singUpOnClickListeners()
        setTextWatchers()

    }

    private fun singUpOnClickListeners() {
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
        if (mailPasswordCheck()) {
            binding.progressBar.visibility = View.VISIBLE

            handler.postDelayed({
                binding.progressBar.visibility = View.GONE
                setDialog()
            }, 2000)
        }

    }

    private fun setDialog() {
        //Bir kere tıklanınca oluyor

        val alertDialogBuilder = AlertDialog.Builder(this)
        val r = Random.nextBoolean()

        if (r) {

            val dialogBinding = DialogLayoutBinding.inflate(layoutInflater)
            alertDialogBuilder.setView(dialogBinding.root)

            val alertDialog = alertDialogBuilder.create()
            alertDialog.window?.setBackgroundDrawableResource(R.drawable.bg_rounded)


            alertDialog.show()

            dialogBinding.button.setOnClickListener {
                alertDialog.dismiss()
            }
        } else {
            val negativeBinding = DialogNegativeBinding.inflate(layoutInflater)
            alertDialogBuilder.setView(negativeBinding.root)
            val alertDialog = alertDialogBuilder.create()
            alertDialog.window?.setBackgroundDrawableResource(R.drawable.bg_rounded)
            alertDialog.show()
            negativeBinding.button2.setOnClickListener {
                alertDialog.dismiss()
            }


        }

    }

    private fun mailPasswordCheck(): Boolean {
        val mail = binding.editTextTextEmailAddress2.text.toString()
        val password = binding.editTextTextPassword.text.toString()
        val password2 = binding.editTextTextPassword2.text.toString()
        if (mail.contains('@') && password.length >= 6 && password == password2) {
            return true
        }
        return false
    }


}




