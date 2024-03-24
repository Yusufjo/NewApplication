package com.example.newapplication.homePage.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newapplication.Post
import com.example.newapplication.R
import com.example.newapplication.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val postList = ArrayList<Post>()
        val p1 = Post(1,"huseyinAcıkgoz","huseyin",378,"huseyin")
        val p2 = Post(2,"JoeFree__","yusuff",478,"yusuff")
        postList.add(p1)
        postList.add(p2)

        val postAdapter  = HomeFragmentAdapter(requireContext(),postList)
        binding.RvPost.adapter = postAdapter

        binding.RvPost.layoutManager = LinearLayoutManager(requireContext())

        return binding.root
    }
}