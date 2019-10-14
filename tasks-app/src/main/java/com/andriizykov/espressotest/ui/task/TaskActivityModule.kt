package com.andriizykov.espressotest.ui.task

import dagger.Binds
import dagger.Module

@Module
abstract class TaskActivityModule {
    @Binds
    abstract fun bindsPresenter(presenter: TasksPresenterImpl) : TasksViewContract.TasksPresenter
    @Binds
    abstract fun bindsView(presenter: TaskActivity) : TasksViewContract.TasksView
}