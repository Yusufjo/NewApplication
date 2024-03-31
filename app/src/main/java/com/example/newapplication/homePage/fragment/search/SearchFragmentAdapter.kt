package com.example.newapplication.homePage.fragment.search

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newapplication.Post
import com.example.newapplication.databinding.SearchCardBinding

class SearchFragmentAdapter(var mContext: Context, var searchList: List<Post>) :
    RecyclerView.Adapter<SearchFragmentAdapter.SearchCardHolder>() {


    inner class SearchCardHolder(var binding: SearchCardBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchCardHolder {
        val binding = SearchCardBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return SearchCardHolder(binding)
    }


    override fun onBindViewHolder(holder: SearchCardHolder, position: Int) {
        val search = searchList.get(position)
        holder.binding.run {
            textViewUserName.text = search.user_name
            profileImage.setImageResource(
                mContext.resources.getIdentifier(
                    search.profile_photo,"drawable",
                    mContext.packageName))
        }
    }

    override fun getItemCount(): Int {
return searchList.size  }
}