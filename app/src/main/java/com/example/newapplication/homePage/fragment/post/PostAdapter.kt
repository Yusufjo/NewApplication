package com.example.newapplication.homePage.fragment.post

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.newapplication.Post
import com.example.newapplication.databinding.ItemPostCardBinding
import com.example.newapplication.homePage.fragment.home.HomeFragmentAdapter
import com.example.newapplication.homePage.fragment.profile.ProfileFragmentDirections

class PostAdapter(var postlists: List<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    inner class PostViewHolder(var binding: ItemPostCardBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = ItemPostCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val posts = postlists.get(position)
        holder.binding.run {
            imageViewPost.setImageResource(posts.postPhoto)
            profileImage.setImageResource(posts.profilePhoto)
            textViewUserName.text = posts.userName
            profileZoomImage.setImageResource(posts.profilePhoto)
            textViewlikeSize.text = posts.likeSize.toString()
        }
        setLikeButton(holder,position)
        setUnLikeButton(holder, position)

    }
    override fun getItemCount(): Int {
        return postlists.size
    }

    fun setLikeButton(holder: PostAdapter.PostViewHolder, position: Int) {
        val post = postlists.get(position)
        val animation = holder.binding.lottieAnimationView

        holder.binding.run {
            imageButtonUnlike.setOnClickListener {
                imageButtonLike.visibility = View.VISIBLE
                imageButtonUnlike.visibility = View.GONE
                post.likeSize++
                textViewlikeSize.text = post.likeSize.toString()

                animation.visibility = View.VISIBLE
                animation.playAnimation()
                animation.postDelayed({
                    animation.cancelAnimation()
                    animation.visibility = View.GONE
                }, 1000)
            }
        }
    }

    fun setUnLikeButton(holder: PostAdapter.PostViewHolder, position: Int) {
        val post = postlists.get(position)
        holder.binding.run {
            imageButtonLike.setOnClickListener {
                imageButtonUnlike.visibility = View.VISIBLE
                imageButtonLike.visibility = View.GONE
                post.likeSize--
                textViewlikeSize.text = post.likeSize.toString()

            }

        }

    }
}