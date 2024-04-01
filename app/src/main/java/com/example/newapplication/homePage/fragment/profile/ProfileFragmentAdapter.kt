package com.example.newapplication.homePage.fragment.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newapplication.Post
import com.example.newapplication.databinding.ItemProfileCardBinding

class ProfileFragmentAdapter(var postListProfile : List<Post>) : RecyclerView.Adapter<ProfileFragmentAdapter.ProfilePostCardHolder>(){
    inner class ProfilePostCardHolder(var binding : ItemProfileCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfilePostCardHolder {
        val binding = ItemProfileCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProfilePostCardHolder(binding)
    }


    override fun onBindViewHolder(holder: ProfilePostCardHolder, position: Int) {
        val post = postListProfile.get(position)
        holder.binding.run {
            imageView3.setImageResource(post.postPhoto)
        }
    }


    override fun getItemCount(): Int {
      return  postListProfile.size
    }
}