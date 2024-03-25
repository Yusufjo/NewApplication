package com.example.newapplication.homePage.fragment.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newapplication.Post
import com.example.newapplication.R
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
        val animation = h.lottieAnimationView



            h.textViewUserName.text = post.user_name

        h.imageViewProfilePhoto.setImageResource(mContext.resources.getIdentifier(post.profile_photo,"drawable",mContext.packageName))
        h.imageViewProfilePhoto.background = mContext.resources.getDrawable(R.drawable.bg_raunded2)

        h.imageViewPost.setImageResource(mContext.resources.getIdentifier(post.postPhoto,"drawable",mContext.packageName))
        h.textViewlikeSize.text = post.like_size.toString()
        var likeSizeTotal = post.like_size

        fun likeButton(){
h.imageButtonUnlike.setOnClickListener {
    h.imageButtonLike.visibility = View.VISIBLE
    h.imageButtonUnlike.visibility = View.GONE
     likeSizeTotal = likeSizeTotal+1
    h.textViewlikeSize.text = likeSizeTotal.toString()
    animation.visibility = View.VISIBLE
    animation.playAnimation()
    animation.postDelayed({
        animation.cancelAnimation()
        animation.visibility = View.GONE
    },1000)
}



        }
        fun unLikeButton() {
            h.imageButtonLike.setOnClickListener {
                h.imageButtonUnlike.visibility = View.VISIBLE
                h.imageButtonLike.visibility = View.GONE
                likeSizeTotal= likeSizeTotal-1
                h.textViewlikeSize.text = likeSizeTotal.toString()
            }
        }



        likeButton()
        unLikeButton()

    }

    override fun getItemCount(): Int {
        return postList.size
    }

}