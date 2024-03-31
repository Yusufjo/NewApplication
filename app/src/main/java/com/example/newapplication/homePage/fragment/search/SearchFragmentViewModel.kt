package com.example.newapplication.homePage.fragment.search

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newapplication.Post
import java.util.Locale

class SearchFragmentViewModel: ViewModel() {

    val searchListLiveData = MutableLiveData<List<Post>>()

    val searchList = listOf<Post>(
        Post(1,"huseyinAcıkgoz","huseyin",378,"huseyinpp"),
        Post(2,"JoeFree__","yusufpp",478,"yusuff"),
        Post(3,"Onurcan.Ozdemir","onurcan",672,"onurcanpp")
    )

    fun initSearchList(){
        searchListLiveData.value = searchList
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