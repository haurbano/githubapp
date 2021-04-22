package com.haur.github.di

import android.app.Activity
import com.haur.github.GithubApp

fun Activity.dependencies() : ActivityCompositionRoot {
    val appCompositionRoot = (application as GithubApp).appCompositionRoot
    val activityCompositionRoot by lazy {
        ActivityCompositionRoot(appCompositionRoot)
    }
    return activityCompositionRoot
}