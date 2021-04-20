package com.haur.github.di

import android.view.LayoutInflater
import android.view.ViewGroup
import com.haur.github.repositories.ui.RepositoriesAdapter
import com.haur.github.repositories.ui.RepositoriesView

class MvcFactory(
    private val layoutInflater: LayoutInflater
    ) {

    fun createRepositoriesView(parent: ViewGroup?): RepositoriesView {
        return RepositoriesView(layoutInflater, parent, RepositoriesAdapter())
    }
}