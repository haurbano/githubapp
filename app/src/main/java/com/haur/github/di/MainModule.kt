package com.haur.github.di

import com.haur.github.common.networking.Constant
import com.haur.github.common.networking.GithubService
import com.haur.github.repositories.domain.FetchRepositoriesUseCase
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val mainModule = module {
    single <Retrofit> {
        Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(GithubService::class.java) }

    factory { FetchRepositoriesUseCase(get()) }

    factory { MvcFactory() }
}