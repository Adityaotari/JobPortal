package com.example.jobportal.students.posts.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bitcodetech.jobportal.R
import com.bitcodetech.jobportal.databinding.PostsFragmentBinding
import com.example.jobportal.commons.factory.ViewModelFactory
import com.example.jobportal.recruiter.addposts.fragments.AddPostFragment
import com.example.jobportal.students.posts.adapter.PostAdapter
import com.example.jobportal.students.posts.repository.PostsRepository
import com.example.jobportal.students.posts.viewmodel.PostsViewModel

class PostsFragment : Fragment() {

    private lateinit var binding : PostsFragmentBinding

    private lateinit var postsViewModel : PostsViewModel
    private lateinit var postsAdapter : PostAdapter
    private var addPostsFragment = AddPostFragment()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PostsFragmentBinding.inflate(layoutInflater)

        initViews()
        initViewModels()
        initAdapter()
        initObservers()
        initListeners()

        postsViewModel.fetchPosts()

        return binding.root
    }

    private fun initListeners() {
        binding.recyclerPosts.addOnScrollListener(
            object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                        postsViewModel.fetchPosts()
                    }
                }
            })


        binding.btnAddPosts.setOnClickListener {
            addPostsFragment()
        }
    }

    private fun addPostsFragment(){
        val addPostFragment = AddPostFragment()
        parentFragmentManager.beginTransaction()
            .add(R.id.mainContainer,addPostFragment, null)
            .addToBackStack(null)
            .commit()
    }

    private fun initObservers() {
        postsViewModel.postsUpdateAvailableLiveData.observe(
            viewLifecycleOwner
        ) {
            if(it) {
                postsAdapter.notifyDataSetChanged()
            }
        }
    }

    private fun initAdapter() {
        postsAdapter = PostAdapter(postsViewModel.posts)
        binding.recyclerPosts.adapter = postsAdapter
    }

    private fun initViewModels() {
        postsViewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                PostsRepository()
            )
        )[PostsViewModel::class.java]
    }

    private fun initViews() {
        binding.recyclerPosts.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL,
            false)
    }
}