package com.haur.github.repositories.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.haur.github.di.MvcFactory
import com.haur.github.repositories.domain.FetchRepositoriesUseCase
import com.haur.github.repositories.ui.RepositoriesView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import javax.inject.Inject

@AndroidEntryPoint
class RepositoriesActivity : AppCompatActivity() {

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    private lateinit var repositoriesView: RepositoriesView

    @Inject
    lateinit var fetchRepositoriesUseCase: FetchRepositoriesUseCase

    @Inject
    lateinit var mvcFactory: MvcFactory

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