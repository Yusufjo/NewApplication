package com.example.newapplication.homePage.fragment.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.newapplication.Post
import com.example.newapplication.databinding.ItemProfileCardBinding
import com.example.newapplication.homePage.fragment.search.SearchFragmentDirections

class ProfileFragmentAdapter(var postListProfile: List<Post>) : RecyclerView.Adapter<ProfileFragmentAdapter.ProfilePostCardHolder>(){
    var onPostClickListener: OnPostClickListener? = null
    inner class ProfilePostCardHolder(var binding : ItemProfileCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfilePostCardHolder {
        val binding = ItemProfileCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProfilePostCardHolder(binding)
    }


    override fun onBindViewHolder(holder: ProfilePostCardHolder, position: Int) {
        val post = postListProfile[position]
        holder.binding.run {
            imageView3.setImageResource(post.postPhoto)
             root.setOnClickListener {
                 onPostClickListener?.onPostClick()
                 val bundle = ProfileFragmentDirections.actionProfileFragmentToHomeFragment(post)
                 Navigation.findNavController(it).navigate(bundle)
             }

    }}


    override fun getItemCount(): Int {
      return  postListProfile.size
    }

    interface OnPostClickListener {
        fun onPostClick()
    }
}