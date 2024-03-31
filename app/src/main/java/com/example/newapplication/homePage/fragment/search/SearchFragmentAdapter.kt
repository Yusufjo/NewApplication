package com.example.newapplication.homePage.fragment.search

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newapplication.Post
import com.example.newapplication.databinding.ItemSearchCardBinding


class SearchFragmentAdapter(var searchList: List<Post>) :
    RecyclerView.Adapter<SearchFragmentAdapter.SearchCardHolder>() {


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
                profileImage.context.resources.getIdentifier(
                    search.profilePhoto,"drawable",
                    profileImage.context.packageName))
        }
    }

    override fun getItemCount(): Int {
return searchList.size  }
}