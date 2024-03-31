package com.example.newapplication.homePage.fragment.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newapplication.Post
import com.example.newapplication.databinding.ItemPostCardBinding


class HomeFragmentAdapter(var postList: List<Post>) :
    RecyclerView.Adapter<HomeFragmentAdapter.PostCardHolder>() {
    inner class PostCardHolder(var binding: ItemPostCardBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostCardHolder {
        val binding =
            ItemPostCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostCardHolder(binding)
    }

    override fun onBindViewHolder(holder: PostCardHolder, position: Int) {
        val post = postList.get(position)

        holder.binding.run {
            textViewUserName.text = post.userName
            imageViewPost.setImageResource(post.postPhoto)
            profileImage.setImageResource(post.profilePhoto)
            profileZoomImage.setImageResource(post.profilePhoto)



            textViewlikeSize.text = post.likeSize.toString()
        }

        SetUpProfilePicture(holder)
        SetLikeButton(holder, position)
        SetUnLikeButton(holder, position)


    }

    override fun getItemCount(): Int {
        return postList.size
    }

    fun SetLikeButton(holder: PostCardHolder, position: Int) {
        val post = postList.get(position)
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

    fun SetUnLikeButton(holder: PostCardHolder, position: Int) {
        val post = postList.get(position)
        holder.binding.run {
            imageButtonLike.setOnClickListener {
                imageButtonUnlike.visibility = View.VISIBLE
                imageButtonLike.visibility = View.GONE
                post.likeSize--
                textViewlikeSize.text = post.likeSize.toString()

            }

        }

    }

    fun SetUpProfilePicture(holder: HomeFragmentAdapter.PostCardHolder) {
        holder.binding.run {
            profileImage.setOnClickListener {
                profileZoomImage.visibility = View.VISIBLE
            }
            root.setOnClickListener {
                if (profileZoomImage.visibility == View.VISIBLE) {
                    profileZoomImage.visibility = View.GONE
                }
            }
        }
    }

}

