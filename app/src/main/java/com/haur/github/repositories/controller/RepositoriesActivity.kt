package com.haur.github.repositories.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.haur.github.repositories.domain.FetchRepositoriesUseCase
import com.haur.github.repositories.ui.RepositoriesView
import kotlinx.coroutines.*

class RepositoriesActivity : AppCompatActivity() {

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    private lateinit var repositoriesView: RepositoriesView
    private lateinit var fetchRepositoriesUseCase: FetchRepositoriesUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repositoriesView = RepositoriesView(layoutInflater, null)
        setContentView(repositoriesView.rootView)
        fetchRepositoriesUseCase = FetchRepositoriesUseCase()
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