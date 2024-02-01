package com.example.jobportal.recruiter.addposts.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bitcodetech.jobportal.R
import com.bitcodetech.jobportal.databinding.JobPostQualificationBinding
import com.example.jobportal.commons.factory.ViewModelFactory
import com.example.jobportal.recruiter.addposts.repository.AddJobPostQualificationRepository
import com.example.jobportal.recruiter.addposts.viewmodel.AddPostQualificationViewModel

class AddJobPostQualificationFragment :  Fragment() {

    private var selectedImage: Int = 0
    private lateinit var addPostQualificationsViewModel: AddPostQualificationViewModel
    private lateinit var binding: JobPostQualificationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = JobPostQualificationBinding.inflate(layoutInflater)

        initViewModels()
        initObserver()
        initViewListeners()
        initImageSelectListener()

        return binding.root
    }

    private fun initViewListeners() {
        binding.btnNext1.setOnClickListener {
            addPostQualificationsViewModel.add(
                selectedImage,
                binding.edtQualification.text.toString(),
                binding.edtMinimumMarks.text.toString(),
                binding.edtPassingYear.text.toString(),
            )

            val addJobPostSkillsFragment = AddJobPostSkillsFragmet()

            parentFragmentManager.beginTransaction()
                .add(R.id.mainContainer, addJobPostSkillsFragment, null)
                .addToBackStack(null)
                .commit()
        }
    }
    private fun initImageSelectListener() {
        binding.img1.setOnClickListener {
          //  selectedImage = R.drawable.tcs
            binding.img1.alpha = 0.5f
        }
    }
    private fun initObserver()
    {
        addPostQualificationsViewModel.addPostMutableLiveData.observe(
            viewLifecycleOwner
        ){
            //parentFragmentManager.popBackStack()
        }
    }    private fun initViewModels(){
        addPostQualificationsViewModel  = ViewModelProvider(
            this,
            ViewModelFactory(
                AddJobPostQualificationRepository()
            )
        )[AddPostQualificationViewModel::class.java]
    }


}