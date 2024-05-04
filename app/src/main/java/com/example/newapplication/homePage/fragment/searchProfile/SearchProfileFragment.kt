package com.example.newapplication.homePage.fragment.searchProfile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.newapplication.Post
import com.example.newapplication.PostData
import com.example.newapplication.R
import com.example.newapplication.databinding.FragmentSearchProfileBinding


class SearchProfileFragment : Fragment() {
    private lateinit var binding: FragmentSearchProfileBinding
    private lateinit var postAdapter: SearchProfileAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val bundle: SearchProfileFragmentArgs by navArgs()
        val profile = bundle.profile

        val postList = when (profile.userName) {
            "JoeFree__" -> PostData.yusufPost
            "Onurcan.Ozdemir" -> PostData.onurcanPost
            "huseyinAcıkgoz" -> PostData.huseyinPost
            else -> PostData.yusufPost
        }


        binding.run {
            profileImage.setImageResource(profile.profilePhoto)
            textViewPostSize.text = postList.size.toString()
            textViewUserName.text = profile.userName
            textViewName.text = profile.name
        }
        postAdapter = SearchProfileAdapter(postList)
        binding.RvPostsSearch.adapter = postAdapter
        binding.RvPostsSearch.layoutManager = GridLayoutManager(context, 3)
    }
}

