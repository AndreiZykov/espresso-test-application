package com.andriizykov.espressotest.di

import android.content.Context
import com.andriizykov.espressotest.SampleApplication
import dagger.Binds
import dagger.Module

@Module
abstract class ApplicationModule {
    @Binds
    abstract fun bindContext(application: SampleApplication) : Context
}