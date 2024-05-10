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
    private lateinit var homeAdapter: HomeFragmentAdapter
    private val viewModel: HomeFragmentViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        homeAdapter = HomeFragmentAdapter()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        observeViewModel()
        viewModel.initHomePostList()
        binding.RvPosts.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun observeViewModel() {
        viewModel.homePostLiveData.observe(viewLifecycleOwner) {
            binding.RvPosts.adapter = homeAdapter
            homeAdapter.postList = it
        }

    }

}