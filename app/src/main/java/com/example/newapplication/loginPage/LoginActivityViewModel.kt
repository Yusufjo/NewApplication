package com.example.newapplication.loginPage

import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newapplication.R
import com.example.newapplication.databinding.DialogNegativeBinding

class LoginActivityViewModel : ViewModel() {

    val errorTextOvservable = MutableLiveData<String?>()
    val profileControllerLiveData = MutableLiveData<Boolean>()

    fun profileController(enteredMail: String, enteredPassword: String): Boolean {
        val mail = "yusuf@gmail.com"
        val password = "123456"
        if (mail == enteredMail && password == enteredPassword) {
            return true
            profileControllerLiveData.value = true
        }
        return false
        profileControllerLiveData.value = false
    }

    fun checkPassword(password: String) {
        if (password.length < 6) {
            errorTextOvservable.value = "Şifreniz minimum 6 karakterli olmalıdır."
        } else {
            errorTextOvservable.value = null
        }
    }

    fun checkEmail(mail: String) {

        if (!mail.contains('@')) {
            errorTextOvservable.value = "Lütfen geçerli bir e-posta adresi giriniz."
        } else {
            errorTextOvservable.value = null
        }
    }




}