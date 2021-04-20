package com.haur.github.di

import android.view.LayoutInflater
import com.haur.github.repositories.domain.FetchRepositoriesUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class ActivityCompositionRoot(
    private val appCompositionRoot: AppCompositionRoot,
    private val layoutInflater: LayoutInflater
    ) {

    val fetchRepositoriesUseCase
    get() = FetchRepositoriesUseCase(appCompositionRoot.githubService)

    val mvcFactory get() = MvcFactory()
}