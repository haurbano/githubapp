package com.haur.github

import android.app.Application

class GithubApp: Application() {
    lateinit var appCompositionRoot: AppCompositionRoot

    override fun onCreate() {
        super.onCreate()
        appCompositionRoot = AppCompositionRoot()
    }
}