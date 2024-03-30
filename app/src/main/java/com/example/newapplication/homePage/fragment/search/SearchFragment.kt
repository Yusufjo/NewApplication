package com.example.newapplication.homePage.fragment.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newapplication.Post
import com.example.newapplication.R
import com.example.newapplication.databinding.FragmentSearchBinding
import java.util.Locale


class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private val viewModel: SearchFragmentViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        observeViewModel()
        viewModel.initSearchList()


        binding.searchViewProfile.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.filterList(newText)
                return true
            }


        })


        binding.searchRV.layoutManager = LinearLayoutManager(requireContext())

        return binding.root
    }

    private fun observeViewModel() {
        viewModel.searchListLiveData.observe(viewLifecycleOwner) {
            val searchAdapter = SearchFragmentAdapter(requireContext(), it)
            binding.searchRV.adapter = searchAdapter
        }
    }

}