package com.haur.github.repositories.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.haur.github.R

class RepositoriesView(
    layoutInflater: LayoutInflater,
    parent: ViewGroup?,
    private val repoAdapter: RepositoriesAdapter // is it needed?
) {
    val rootView: View = layoutInflater.inflate(R.layout.activity_repositories, parent, false)
    private val recyclerView = findViewById<RecyclerView>(R.id.repositoriesRV)

    init {
        recyclerView.apply {
            adapter = repoAdapter
            layoutManager = LinearLayoutManager(rootView.context)
        }
    }

    fun bindRepositories(repos: List<String>) {
        repoAdapter.setRepositories(repos)
    }

    private fun <T: View> findViewById(viewId: Int): T {
        return rootView.findViewById(viewId)
    }
}