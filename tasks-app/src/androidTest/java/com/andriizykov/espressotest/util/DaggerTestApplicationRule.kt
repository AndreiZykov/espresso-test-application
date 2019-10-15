package com.andriizykov.espressotest.util

import androidx.test.core.app.ApplicationProvider
import com.andriizykov.espressotest.di.ApplicationTestComponent
import com.andriizykov.espressotest.di.DaggerApplicationTestComponent
import com.andriizykov.espressotest.di.DummyApplication
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class DaggerTestApplicationRule : TestWatcher() {

    lateinit var component: ApplicationTestComponent
        private set

    override fun starting(description: Description?) {
        super.starting(description)

        val app = ApplicationProvider.getApplicationContext<DummyApplication>()
        component = DaggerApplicationTestComponent.factory().create(app)
        component.inject(app)
    }
}