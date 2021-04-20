package com.haur.github.repositories.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.haur.github.di.dependencies
import com.haur.github.repositories.domain.FetchRepositoriesUseCase
import com.haur.github.repositories.ui.RepositoriesView
import kotlinx.coroutines.*

class RepositoriesActivity : AppCompatActivity() {

    private lateinit var repositoriesView: RepositoriesView
    private lateinit var fetchRepositoriesUseCase: FetchRepositoriesUseCase
    private lateinit var coroutineScope: CoroutineScope

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repositoriesView = dependencies().mvcFactory.createRepositoriesView(null)
        setContentView(repositoriesView.rootView)
        coroutineScope = dependencies().coroutineScope
        fetchRepositoriesUseCase = dependencies().fetchRepositoriesUseCase
    }

    override fun onStart() {
        super.onStart()
        fetchRepos()
    }

    override fun onStop() {
        super.onStop()
        coroutineScope.cancel()
    }

    private fun fetchRepos() {
        coroutineScope.launch {
            val repositories = fetchRepositoriesUseCase.fetch("haurbano")
            repositoriesView.bindRepositories(repositories)
        }
    }
}