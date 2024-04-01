package com.example.newapplication.homePage.fragment.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileFragmentViewModel : ViewModel() {
    val  profileUserNameLiveData = MutableLiveData<String>()

    fun setProfileUserName(userName:String){
        userName
    }
}