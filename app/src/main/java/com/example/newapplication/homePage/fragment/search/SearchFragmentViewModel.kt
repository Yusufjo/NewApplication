package com.example.newapplication.homePage.fragment.search

import android.widget.Adapter
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newapplication.Post
import com.example.newapplication.R
import java.util.Locale

class SearchFragmentViewModel: ViewModel() {
    private lateinit var searchAdapter: SearchFragmentAdapter

    val searchListLiveData = MutableLiveData<MutableList<Post>>()

    var searchList = mutableListOf<Post>(
        Post("Hüseyin",1,"huseyinAcıkgoz", R.drawable.huseyin,378,R.drawable.huseyinpp),
        Post("Yusuf",2,"JoeFree__",R.drawable.yusufpp,478,R.drawable.yusuff),
        Post("Onurcan Ozdemir",3,"Onurcan.Ozdemir",R.drawable.onurcan,672,R.drawable.onurcanpp)
    )

    fun initSearchList(){
        searchListLiveData.value = searchList
    }

    fun initAdapter(){
        searchAdapter = SearchFragmentAdapter()
    }


    fun filterList(query :String?){
        if (query!=null){
            val filteredList = ArrayList<Post>()
            for (i in searchList){

                if(i.userName.lowercase(Locale.ROOT).contains(query)){
                    filteredList.add(i)
                }
                else if (i.userName.capitalize(Locale.ROOT).contains(query)){
                    filteredList.add(i)
                }

            }
            searchListLiveData.value = filteredList


        }

    }


}