package com.example.newapplication.homePage.fragment.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.newapplication.Post
import com.example.newapplication.R
import com.example.newapplication.databinding.FragmentProfileBinding
import com.example.newapplication.homePage.fragment.home.HomeFragment


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
        observeViewModel()
        viewModel.initProfileList()
        val postList = viewModel.postList

        binding.run {
            profileImage.setImageResource(R.drawable.yusufpp)
            textViewPostSize.text = postList.size.toString()
            textViewUserName.text = postList[1].userName
            textViewName.text = postList[0].name
        }

        postAdapter = ProfileFragmentAdapter(postList)
        binding.Rv.layoutManager = GridLayoutManager(context, postList.size)
    }

    private fun observeViewModel() {
        viewModel.profilePostSizeLiveData.observe(viewLifecycleOwner) {
            binding.Rv.adapter = postAdapter
            postAdapter.postListProfile = it
        }
    }
}

