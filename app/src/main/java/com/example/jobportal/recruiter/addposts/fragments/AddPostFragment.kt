package com.example.jobportal.recruiter.addposts.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bitcodetech.jobportal.R
import com.bitcodetech.jobportal.databinding.AddPostBinding
import com.bitcodetech.jobportal.databinding.JobPostSkillsBinding
import com.example.jobportal.commons.factory.ViewModelFactory
import com.example.jobportal.recruiter.addposts.repository.AddPostRepository
import com.example.jobportal.recruiter.addposts.viewmodel.AddPostSkillsViewModel
import com.example.jobportal.recruiter.addposts.viewmodel.AddPostViewModel

class AddPostFragment:Fragment() {
    private lateinit var binding : AddPostBinding
    private lateinit var addPostViewModel: AddPostViewModel
    private var selectedImage : Int =0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AddPostBinding.inflate(layoutInflater)

        initViewModels()
        initObserver()
        initViewListeners()
        initImageSelectListener()

        return binding.root
    }
    private fun initViewListeners(){

        binding.btnAddPost.setOnClickListener {
            addPostViewModel.addPost(
                selectedImage,
                binding.edtJobTitle.text.toString(),
                binding.edtJobDescription.text.toString(),
                binding.edtSalary.text.toString(),
                binding.edtPostedDate.text.toString(),
                binding.edtBefints.text.toString(),
                binding.edtJoinigDate.text.toString(),
                binding.edtEmploymemtType.text.toString(),
                binding.edtWorkMode.text.toString(),

                )
            val addJobPostQualificationsFragment = AddJobPostQualificationFragment()

            parentFragmentManager.beginTransaction()
                .add(R.id.mainContainer,addJobPostQualificationsFragment,null)
                .addToBackStack(null)
                .commit()

        }
    }
    private fun initImageSelectListener() {
        binding.img1.setOnClickListener {
         //   selectedImage = R.drawable.tcs
            binding.img1.alpha = 0.5f
        }
    }
    private fun initObserver()
    {
        addPostViewModel.addPostMutableLiveData.observe(
            viewLifecycleOwner
        ){
            //parentFragmentManager.popBackStack()
        }
    }    private fun initViewModels(){
        addPostViewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                AddPostRepository()
            )
        )[AddPostViewModel::class.java]
    }

}