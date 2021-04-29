package com.haur.github.di

import com.haur.github.common.networking.Constant
import com.haur.github.common.networking.GithubService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppCompositionRoot {
    private val retrofitClient: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val githubService: GithubService by lazy {
        retrofitClient.create(GithubService::class.java)
    }
}