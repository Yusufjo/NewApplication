package com.example.newapplication.signupPage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpActivityViewModel: ViewModel() {
    val errorTextObservable = MutableLiveData<String?>()
    val signUpControllerLiveData = MutableLiveData<Boolean>()

     fun mailCheck(mail: String) {
        if (!mail.contains('@')) {
            errorTextObservable.value = "Lütfen geçerli bir e-posta adresi giriniz."
        } else {
            errorTextObservable.value = null
        }
    }

     fun passwordCheck(password:String) {
        if (password.length < 6) {
            errorTextObservable.value = "Şifreniz minimum 6 karakterli olmalıdır."
        } else {
            errorTextObservable.value = null
        }
    }

     fun passwordDoubleCheck(password: String,password2: String) {
        if (password != password2) {
            errorTextObservable.value =
                "Şifreler aynı olmalıdır. Lütfen kontrol ederek tekrar deneyiniz."
        } else {
            errorTextObservable.value = null
        }
    }

     fun mailPasswordCheck(mail: String,password: String,password2: String): Boolean {
        if (mail.contains('@') && password.length >= 6 && password == password2) {
            return true
            signUpControllerLiveData.value = true
        }
        return false
         signUpControllerLiveData.value = false
    }
}