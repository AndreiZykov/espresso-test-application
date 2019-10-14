package com.andriizykov.model.di

import com.andriizykov.model.task.TaskDataSource
import com.andriizykov.model.task.TaskRepository
import dagger.Binds
import dagger.Module

@Module
abstract class ModelModule {

    @Binds
    abstract fun binds(taskRepository: TaskRepository): TaskDataSource

}