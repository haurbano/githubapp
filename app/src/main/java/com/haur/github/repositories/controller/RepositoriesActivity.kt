package com.haur.github.repositories.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.haur.github.di.MvcFactory
import com.haur.github.repositories.domain.FetchRepositoriesUseCase
import com.haur.github.repositories.ui.RepositoriesView
import kotlinx.coroutines.*
import org.koin.android.ext.android.inject

class RepositoriesActivity : AppCompatActivity() {

    private val coroutineScope: CoroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    private lateinit var repositoriesView: RepositoriesView
    private val fetchRepositoriesUseCase: FetchRepositoriesUseCase by inject()
    private val mvcFactory: MvcFactory by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repositoriesView = mvcFactory.createRepositoriesView(layoutInflater, null)
        setContentView(repositoriesView.rootView)
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