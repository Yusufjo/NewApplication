package com.example.newapplication.homePage.fragment.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newapplication.Post
import com.example.newapplication.databinding.PostCardBinding

class HomeFragmentAdapter(var mContext: Context, var postList: List<Post>) :
    RecyclerView.Adapter<HomeFragmentAdapter.PostCardHolder>() {
    inner class PostCardHolder(var binding: PostCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostCardHolder {
        val binding = PostCardBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return PostCardHolder(binding)
    }

    override fun onBindViewHolder(holder: PostCardHolder, position: Int) {
        val post = postList.get(position)
        val h = holder.binding
        h.textViewUserName.text = post.user_name
        h.imageViewProfilePhoto.setImageResource(mContext.resources.getIdentifier(post.profile_photo,"drawable",mContext.packageName))

        h.imageViewPost.setImageResource(mContext.resources.getIdentifier(post.postPhoto,"drawable",mContext.packageName))
        h.textViewlikeSize.text = post.like_size.toString()
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}