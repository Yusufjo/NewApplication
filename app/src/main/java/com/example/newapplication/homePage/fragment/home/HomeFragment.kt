package com.example.newapplication.homePage.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newapplication.Post
import com.example.newapplication.R
import com.example.newapplication.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel:HomeFragmentViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val postList = listOf<Post>(Post(1,"huseyinAcıkgoz","huseyin",378,"huseyinpp"),
            Post(2,"JoeFree__","yusufpp",478,"yusuff"),
            Post(3,"Onurcan.Ozdemir","onurcan",672,"onurcanpp"))

        val postAdapter  = HomeFragmentAdapter(requireContext(),postList)
        binding.RvPost.adapter = postAdapter



        binding.RvPost.layoutManager = LinearLayoutManager(requireContext())

        return binding.root
    }


}