package com.example.newapplication.homePage.fragment.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newapplication.Post
import com.example.newapplication.R

class ProfileFragmentViewModel : ViewModel() {
    val  profilePostSizeLiveData = MutableLiveData<String>()

    val postList = listOf<Post>( Post("Yusuf",2,"JoeFree__", R.drawable.yusufpp,478, R.drawable.yusuff),
        Post("Yusuf",2,"JoeFree__", R.drawable.yusufpp,478, R.drawable.yusufpp),
        Post("Yusuf",2,"JoeFree__", R.drawable.yusufpp,478, R.drawable.onurcan)
    )

    fun setProfilePostSize(){
        profilePostSizeLiveData.value = postList.size.toString()
    }
}