package com.haur.github

import android.app.Application
import com.haur.github.di.mainModule
import org.koin.core.context.startKoin

class GithubApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(mainModule)
        }
    }
}