package com.example.newapplication.homePage.fragment.post

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.newapplication.Post
import com.example.newapplication.PostData
import com.example.newapplication.R
import com.example.newapplication.databinding.FragmentPostBinding


class PostFragment : Fragment() {
    private lateinit var binding: FragmentPostBinding
    private lateinit var postAdapter: PostAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val bundle:PostFragmentArgs by navArgs()
        val post = bundle.posts

        val postList = when (post.userName) {
            "JoeFree__" -> PostData.yusufPost
            "Onurcan.Ozdemir" -> PostData.onurcanPost
            "huseyinAcıkgoz" -> PostData.huseyinPost
            else -> PostData.yusufPost
        }


        postAdapter = PostAdapter(postList)
        binding.postsView.adapter = postAdapter
        binding.postsView.layoutManager = LinearLayoutManager(requireContext())



    }
}