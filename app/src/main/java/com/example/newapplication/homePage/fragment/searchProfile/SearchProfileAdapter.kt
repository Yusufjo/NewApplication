package com.example.newapplication.homePage.fragment.searchProfile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newapplication.Post
import com.example.newapplication.PostData
import com.example.newapplication.databinding.ItemProfileCardBinding


class SearchProfileAdapter( var searchProfileList: List<Post>): RecyclerView.Adapter<SearchProfileAdapter.SearchProfileCardHolder>() {


    inner class SearchProfileCardHolder(var binding: ItemProfileCardBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchProfileCardHolder {
        val binding = ItemProfileCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SearchProfileCardHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchProfileCardHolder, position: Int) {
        val post = searchProfileList.get(position)
        holder.binding.run {
            this.imageView3.setImageResource(post.postPhoto)

        }
    }
    override fun getItemCount(): Int {
        return searchProfileList.size
    }
}
