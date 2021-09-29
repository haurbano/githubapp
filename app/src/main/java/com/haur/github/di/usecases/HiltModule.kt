package com.haur.github.di.usecases

import com.haur.github.common.networking.Constant
import com.haur.github.common.networking.GithubService
import com.haur.github.repositories.domain.FetchRepositoriesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object HiltModule {

    @Singleton
    @Provides
    fun providesRetrofitClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideGitgubService(retrofit: Retrofit): GithubService {
        return retrofit.create(GithubService::class.java)
    }

    @Provides
    fun providesFetchRepositoriesUseCase(githubService: GithubService): FetchRepositoriesUseCase {
        return FetchRepositoriesUseCase(githubService)
    }
}