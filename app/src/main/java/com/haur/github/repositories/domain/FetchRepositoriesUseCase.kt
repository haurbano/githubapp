package com.haur.github.repositories.domain

import com.haur.github.common.networking.Constant
import com.haur.github.common.networking.GithubService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FetchRepositoriesUseCase() {
    private val retrofitClient: Retrofit = Retrofit.Builder()
        .baseUrl(Constant.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val githubService = retrofitClient.create(GithubService::class.java)

    suspend fun fetch(user: String): List<String> = withContext(Dispatchers.IO) {
        return@withContext githubService.fetchRepositories(user).map { it.name }
    }
}