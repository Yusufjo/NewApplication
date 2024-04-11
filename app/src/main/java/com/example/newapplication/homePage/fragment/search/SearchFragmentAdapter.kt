package com.example.newapplication.homePage.fragment.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.newapplication.Post
import com.example.newapplication.R
import com.example.newapplication.databinding.ItemSearchCardBinding


class SearchFragmentAdapter :
    RecyclerView.Adapter<SearchFragmentAdapter.SearchCardHolder>() {
    var searchList = mutableListOf<Post>()

    inner class SearchCardHolder(var binding: ItemSearchCardBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchCardHolder {
        val binding = ItemSearchCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SearchCardHolder(binding)
    }


    override fun onBindViewHolder(holder: SearchCardHolder, position: Int) {
        val search = searchList.get(position)
        holder.binding.run {
            textViewUserName.text = search.userName
            profileImage.setImageResource(
                search.profilePhoto)
            root.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("username",search.userName)
                bundle.putInt("profilephoto",search.profilePhoto)
                it.findNavController().navigate(R.id.action_searchFragment_to_profileFragment, bundle)
            }
        }


    }


    override fun getItemCount(): Int {
return searchList.size  }
}