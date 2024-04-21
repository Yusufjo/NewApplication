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

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val postList = listOf<Post>(
            Post("Hüseyin",1, "huseyinAcıkgoz", R.drawable.huseyin, 378, R.drawable.huseyinpp),
            Post("Yusuf",2, "JoeFree__", R.drawable.yusufpp, 478, R.drawable.yusuff),
            Post("Onurcan Özdemir",3, "Onurcan.Ozdemir", R.drawable.onurcan, 672, R.drawable.onurcanpp)
        )
        homeAdapter = HomeFragmentAdapter(postList)
        binding.RvPosts.adapter = homeAdapter
        binding.RvPosts.layoutManager = LinearLayoutManager(requireContext())
    }


}