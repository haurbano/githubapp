package com.haur.github.di

import android.view.LayoutInflater
import android.view.ViewGroup
import com.haur.github.repositories.ui.RepositoriesAdapter
import com.haur.github.repositories.ui.RepositoriesView
import javax.inject.Inject

class MvcFactory @Inject constructor() {

    fun createRepositoriesView(layoutInflater: LayoutInflater, parent: ViewGroup?): RepositoriesView {
        return RepositoriesView(layoutInflater, parent, RepositoriesAdapter())
    }
}