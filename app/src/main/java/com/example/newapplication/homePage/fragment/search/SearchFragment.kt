package com.example.newapplication.homePage.fragment.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newapplication.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var searchAdapter: SearchFragmentAdapter
    private val viewModel: SearchFragmentViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        searchAdapter = SearchFragmentAdapter()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        observeViewModel()
        viewModel.initSearchList()
        viewModel.initAdapter()


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

    }

    private fun observeViewModel() {
        viewModel.searchListLiveData.observe(viewLifecycleOwner) {
            binding.searchRV.adapter = searchAdapter
            searchAdapter.searchList = it
        }
    }

}