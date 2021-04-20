package com.haur.github

import android.app.Application
import com.haur.github.di.AppCompositionRoot

class GithubApp: Application() {
    lateinit var appCompositionRoot: AppCompositionRoot

    override fun onCreate() {
        super.onCreate()
        appCompositionRoot = AppCompositionRoot()
    }
}