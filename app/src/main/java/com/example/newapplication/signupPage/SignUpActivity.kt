package com.example.newapplication.signupPage

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newapplication.R
import com.example.newapplication.databinding.ActivitySignUpBinding
import com.example.newapplication.databinding.DialogLayoutBinding
import com.example.newapplication.databinding.DialogNegativeBinding
import kotlin.random.Random

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var viewModel: SignUpActivityViewModel
    private val handler = Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[SignUpActivityViewModel::class.java]

        singUpOnClickListeners()
        setTextWatchers()

    }



    private fun singUpOnClickListeners() {
        binding.singUp.setOnClickListener {
            val mail = binding.editTextTextEmailAddress2.text.toString()
            val password = binding.editTextTextPassword.text.toString()
            val password2 = binding.editTextTextPassword2.text.toString()
            viewModel.mailCheck(mail)
           viewModel.passwordCheck(password)
            viewModel.passwordDoubleCheck(password,password2)
           showProgressBar()

        }
    }

    private fun setTextWatchers() {
        mailTextWatcher()
        passwordTextWatcher()
        confirmPasswordTextWatcher()
    }
    private fun mailTextWatcher() {
        binding.editTextTextEmailAddress2.doAfterTextChanged {
            viewModel.mailCheck(it.toString())
            binding.textInputLayout.error = viewModel.errorTextObservable.value
        }
    }
    private fun passwordTextWatcher() {
        binding.editTextTextPassword.doAfterTextChanged {
           viewModel.passwordCheck(it.toString())
            binding.passwordEditText.error = viewModel.errorTextObservable.value
        }
    }
    private fun confirmPasswordTextWatcher() {
        binding.editTextTextPassword2.doAfterTextChanged {
            val password = binding.editTextTextPassword.text.toString()
            viewModel.passwordDoubleCheck(password,it.toString())
            binding.passwordEditText.error = viewModel.errorTextObservable.value
        }
    }

    private fun showProgressBar() {
        val mail = binding.editTextTextEmailAddress2.text.toString()
        val password = binding.editTextTextPassword.text.toString()
        val password2 = binding.editTextTextPassword2.text.toString()
        if (viewModel.mailPasswordCheck(mail,password,password2)) {
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



}




