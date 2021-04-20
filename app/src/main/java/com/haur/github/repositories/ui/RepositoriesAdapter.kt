package com.haur.github.repositories.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.haur.github.R

class RepositoriesAdapter: RecyclerView.Adapter<RepositoriesAdapter.ViewHolder>() {
    private val repos = arrayListOf<String>()

    fun setRepositories(data: List<String>) {
        repos.clear()
        repos.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val repoNameTxt: TextView = view.findViewById(R.id.repoNameTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_repository_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.repoNameTxt.text = repos[position]
    }

    override fun getItemCount() = repos.size
}