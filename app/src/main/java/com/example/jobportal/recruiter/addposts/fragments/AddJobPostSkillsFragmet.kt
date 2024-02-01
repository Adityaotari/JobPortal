package com.example.jobportal.recruiter.addposts.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bitcodetech.jobportal.R
import com.bitcodetech.jobportal.databinding.JobPostSkillsBinding
import com.example.jobportal.commons.factory.ViewModelFactory
import com.example.jobportal.recruiter.addposts.repository.AddJobPostSkillsRepository
import com.example.jobportal.recruiter.addposts.viewmodel.AddPostSkillsViewModel
import com.example.jobportal.students.posts.fragments.PostsFragment

class AddJobPostSkillsFragmet: Fragment() {
    private lateinit var binding: JobPostSkillsBinding
    private lateinit var addPostSkillsViewModel: AddPostSkillsViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= JobPostSkillsBinding.inflate(layoutInflater)

        binding.checkBox1.setOnCheckedChangeListener { _, isChecked ->
            updateResultTextView(isChecked, binding.checkBox1.text.toString())
        }

        binding.checkBox2.setOnCheckedChangeListener { _, isChecked ->
            updateResultTextView(isChecked, binding.checkBox2.text.toString())
        }
        binding.checkBox3.setOnCheckedChangeListener { _, isChecked ->
            updateResultTextView(isChecked, binding.checkBox3.text.toString())

        }

        initViewModels()
        initObserver()
        initViewListeners()
        initImageSelectListener()


        return binding.root
    }

    private fun initViewListeners(){
        binding.btnSubmit.setOnClickListener {
            addPostSkillsViewModel.add(
                binding.resultTextView.text.toString()
            )

            val postFragment = PostsFragment()

            parentFragmentManager.beginTransaction()
                .add(R.id.mainContainer, postFragment, null)
                .addToBackStack(null)
                .commit()
        }

    }
    private fun initImageSelectListener(){
        binding.img1.setOnClickListener {
            //  selectedImage = R.drawable.tcs  `
            binding.img1.alpha = 0.5f
        }
    }
    private fun initObserver(){

        addPostSkillsViewModel.addPostMutableLiveData.observe(
            viewLifecycleOwner
        ){
            //parentFragmentManager.popBackStack()

        }}
    private fun initViewModels(){
        addPostSkillsViewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                AddJobPostSkillsRepository()
            )
        )[AddPostSkillsViewModel::class.java]
    }


    private fun updateResultTextView(isChecked: Boolean, data: String) {
        val currentText = binding.resultTextView.text.toString()

        if (isChecked) {
            // Checkbox is checked, add data to the resultTextView
            val newText = if (currentText.isEmpty()) {
                data
            } else {
                "$currentText, $data"
            }
            binding.resultTextView.text = newText
        } else {
            // Checkbox is unchecked, remove data from the resultTextView
            val newText = currentText.replace("$data, ", "").replace(data, "")
            binding.resultTextView.text = newText
        }
    }
}