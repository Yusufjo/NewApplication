package com.example.newapplication.homePage.fragment.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newapplication.Post
import com.example.newapplication.R
import com.example.newapplication.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var postAdapter: ProfileFragmentAdapter
    private val viewModel: ProfileFragmentViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val postList = listOf<Post>( Post(2,"JoeFree__",R.drawable.yusufpp,478,R.drawable.yusuff),
            Post(2,"JoeFree__",R.drawable.yusufpp,478,R.drawable.yusufpp),
            Post(2,"JoeFree__",R.drawable.yusufpp,478,R.drawable.onurcan))
        binding.profileImage.setImageResource(postList[2].profilePhoto)
        binding.textViewPostSize.text = postList.size.toString()
        binding.textViewUserName.text = postList[1].userName

        postAdapter = ProfileFragmentAdapter(postList)
        binding.RvPosts.adapter = postAdapter
        binding.RvPosts.layoutManager = GridLayoutManager(context,postList.size)
    }
}

