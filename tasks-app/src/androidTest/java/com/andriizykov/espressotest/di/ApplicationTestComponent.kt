package com.andriizykov.espressotest.di

import android.content.Context
import com.andriizykov.model.task.TaskDataSource
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, AndroidInjectionModule::class, ActivityModule::class, MockModelModule::class])
interface ApplicationTestComponent : AndroidInjector<DummyApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationTestComponent
    }
    val tasksRepository: TaskDataSource
}