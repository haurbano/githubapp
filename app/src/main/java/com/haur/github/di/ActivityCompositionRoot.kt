package com.haur.github.di

import com.haur.github.repositories.domain.FetchRepositoriesUseCase

class ActivityCompositionRoot(
    private val appCompositionRoot: AppCompositionRoot,
    ) {

    val fetchRepositoriesUseCase
    get() = FetchRepositoriesUseCase(appCompositionRoot.githubService)

    val mvcFactory get() = MvcFactory()
}