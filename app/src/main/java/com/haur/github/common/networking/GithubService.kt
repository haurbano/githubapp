package com.haur.github.common.networking

import com.haur.github.repositories.networking.Repository
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    @GET("/users/{user}/repos")
    suspend fun fetchRepositories(@Path("user") user: String): List<Repository>
}