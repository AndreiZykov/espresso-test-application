package com.andriizykov.espressotest.di

import com.andriizykov.espressotest.ui.task.TaskActivity
import com.andriizykov.espressotest.ui.task.TaskActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector



@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [TaskActivityModule::class])
    internal abstract fun contributeTaskActivity(): TaskActivity
}