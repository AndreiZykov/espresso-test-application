package com.andriizykov.espressotest.di

import com.andriizykov.espressotest.SampleApplication
import com.andriizykov.model.di.ModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, AndroidInjectionModule::class, ActivityModule::class, ModelModule::class])
interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun bindApplication(application: SampleApplication): Builder
        fun build(): ApplicationComponent
    }
    fun inject(application: SampleApplication)
}