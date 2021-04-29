package com.haur.github.repositories.domain

import com.haur.github.common.networking.GithubService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FetchRepositoriesUseCase(private val githubService: GithubService) {

    suspend fun fetch(user: String): List<String> = withContext(Dispatchers.IO) {
        return@withContext githubService.fetchRepositories(user).map { it.name }
    }
}