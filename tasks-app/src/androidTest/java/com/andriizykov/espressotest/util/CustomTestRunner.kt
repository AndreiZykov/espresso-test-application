package com.andriizykov.espressotest.util

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import com.andriizykov.espressotest.SampleApplication
import com.andriizykov.espressotest.di.DummyApplication

class CustomTestRunner : AndroidJUnitRunner() {
    override fun newApplication(cl: ClassLoader?, name: String?, context: Context?): Application {
        return super.newApplication(cl, SampleApplication::class.java.name, context)
    }
}
