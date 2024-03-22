package com.example.newapplication.loginPage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModelProvider
import com.example.newapplication.homePage.HomePageActivity
import com.example.newapplication.R
import com.example.newapplication.signupPage.SignUpActivity
import com.example.newapplication.databinding.ActivityMainBinding
import com.example.newapplication.databinding.DialogNegativeBinding

class LogInActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    //private val viewModel: LoginActivityViewModel by viewModels()
    private lateinit var viewModel:LoginActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[LoginActivityViewModel::class.java]

        setOnClickListeners()
        textWatchers()
    }


    private fun setOnClickListeners() {
        singUpOnClickListener()
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
            val mail = binding.mailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            if (viewModel.profileController(mail, password)) {
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


    private fun textWatchers() {
        mailTextWatcher()
        passwordTextWathcher()
    }
    private fun passwordTextWathcher() {
        binding.passwordEditText.doAfterTextChanged {
            it?.let {
                viewModel.checkPassword(it.toString())
                binding.passwordLayout.error = viewModel.errorTextOvservable.value
            }
        }
    }
    private fun mailTextWatcher() {
        binding.mailEditText.doAfterTextChanged {
            viewModel.checkEmail(it.toString())
            binding.textInputLayout.error = viewModel.errorTextOvservable.value
        }
    }


}
