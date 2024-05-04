package com.example.newapplication.homePage.fragment.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newapplication.Post
import com.example.newapplication.R

class ProfileFragmentViewModel : ViewModel() {
    val  profilePostSizeLiveData = MutableLiveData<MutableList<Post>>()

    val postList = mutableListOf<Post>( Post("Yusuf",2,"JoeFree__", R.drawable.yusufpp,478, R.drawable.yusuff),
        Post("Yusuf",2,"JoeFree__", R.drawable.yusufpp,478, R.drawable.yusufpp),
        Post("Yusuf",2,"JoeFree__", R.drawable.yusufpp,478, R.drawable.onurcan)
    )

    fun initProfileList(){
        profilePostSizeLiveData.value = postList
    }
}