package com.example.jobportal.students.posts.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bitcodetech.jobportal.R
import com.bitcodetech.jobportal.databinding.JobsPostBinding
import com.example.jobportal.students.posts.models.JobsPost

class PostAdapter(
    private val posts: ArrayList<JobsPost>
) : RecyclerView.Adapter<PostAdapter.PostsViewHolder>() {

    interface OnPostClickListener{
        fun onPostListener(post: JobsPost,position: Int, postAdapter: PostAdapter)
    }
    var onPostClickListener : OnPostClickListener? = null
    inner class PostsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val postViewBinding: JobsPostBinding
        init {
            postViewBinding = JobsPostBinding.bind(view)
        }
    }

    override fun getItemCount() = posts.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        return PostsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.jobs_post, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.postViewBinding.txtTitle.text = posts[position].title
        holder.postViewBinding.txtSalary.text = posts[position].jobSalary.toString()
        holder.postViewBinding.txtCompanyName.text = posts[position].companyName
        holder.postViewBinding.txtLocation.text = posts[position].location
    }
}