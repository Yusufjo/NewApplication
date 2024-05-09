package com.example.newapplication.homePage.fragment.home

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newapplication.Post
import com.example.newapplication.R

class HomeFragmentViewModel : ViewModel() {
    val homePostLiveData = MutableLiveData<MutableList<Post>>()

    val postList = mutableListOf<Post>(
        Post("Hüseyin",1, "huseyinAcıkgoz", R.drawable.huseyin, 378, R.drawable.huseyinpp),
        Post("Yusuf",2, "JoeFree__", R.drawable.yusufpp, 478, R.drawable.yusuff),
        Post("Onurcan Özdemir",3, "Onurcan.Ozdemir", R.drawable.onurcan, 672, R.drawable.onurcanpp)
    )

    fun initHomePostList(){
        homePostLiveData.value = postList
    }
}