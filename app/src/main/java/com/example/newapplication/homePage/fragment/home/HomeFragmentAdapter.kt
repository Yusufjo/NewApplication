package com.example.newapplication.homePage.fragment.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
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
        val animation = holder.binding.lottieAnimationView

        holder.binding.run {
            textViewUserName.text = post.user_name

            imageViewPost.setImageResource(
                mContext.resources.getIdentifier(
                    post.profile_photo,
                    "drawable",
                    mContext.packageName
                )
            )
            profileImage.setImageResource(
                mContext.resources.getIdentifier(
                    post.postPhoto,
                    "drawable",
                    mContext.packageName
                )
            )

            profileZoomImage.setImageResource(
                mContext.resources.getIdentifier(
                    post.postPhoto, "drawable",
                    mContext.packageName
                )
            )

            textViewlikeSize.text = post.like_size.toString()
        }


        var likeSizeTotal = post.like_size


        fun SetUpProfilePicture() {
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
        SetUpProfilePicture()

        fun SetLikeButton() {
            holder.binding.run {
                imageButtonUnlike.setOnClickListener {
                    imageButtonLike.visibility = View.VISIBLE
                    imageButtonUnlike.visibility = View.GONE
                    likeSizeTotal = likeSizeTotal + 1
                    textViewlikeSize.text = likeSizeTotal.toString()
                    animation.visibility = View.VISIBLE
                    animation.playAnimation()
                    animation.postDelayed({
                        animation.cancelAnimation()
                        animation.visibility = View.GONE
                    }, 1000)
                }

            }


        }

        fun SetUnLikeButton() {
            holder.binding.run {
                imageButtonLike.setOnClickListener {
                    imageButtonUnlike.visibility = View.VISIBLE
                    imageButtonLike.visibility = View.GONE
                    likeSizeTotal = likeSizeTotal - 1
                    textViewlikeSize.text = likeSizeTotal.toString()
                }

            }

        }

        SetLikeButton()
        SetUnLikeButton()

    }

    override fun getItemCount(): Int {
        return postList.size
    }

}