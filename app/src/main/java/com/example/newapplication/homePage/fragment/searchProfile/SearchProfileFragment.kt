
package com.example.newapplication.homePage.fragment.searchProfile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.newapplication.Post
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

        val postList = listOf<Post>(
            Post("yusuf", 2, "JoeFree__", R.drawable.yusufpp, 478, R.drawable.yusuff),
            Post("yusuf", 2, "JoeFree__", R.drawable.yusufpp, 478, R.drawable.yusufpp),
            Post("yusuf", 2, "JoeFree__", R.drawable.yusufpp, 478, R.drawable.onurcan)
        )

        binding.run {
            profileImage.setImageResource(profile.profilePhoto)
            textViewPostSize.text = postList.size.toString()
            textViewUserName.text = profile.userName
            textViewName.text = profile.name
        }
        postAdapter = SearchProfileAdapter(postList)
        binding.RvPostsSearch.adapter = postAdapter
        binding.RvPostsSearch.layoutManager = GridLayoutManager(context,3)
    }
}

