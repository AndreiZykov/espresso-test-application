package com.andriizykov.espressotest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.andriizykov.espressotest.ui.task.TaskActivity
import com.andriizykov.espressotest.util.DaggerTestApplicationRule
import com.andriizykov.espressotest.util.RecyclerViewItemCountAssertion
import org.junit.Rule
import org.junit.Test

class TaskActivityEspressoTestMockWithDagger {

    @get:Rule
    val daggerRule = DaggerTestApplicationRule()

    @get:Rule
    var activityRule = ActivityTestRule(TaskActivity::class.java)

    @Test
    fun screenHasNewTasksButtonAndItIsVisible() {
        onView(withId(R.id.new_task_button))
            .check(matches(isDisplayed()))
    }

    @Test
    fun tasksRepoReturns3Tasks_recyclerViewShouldHave3tasks() {
        onView(withId(R.id.recycler_view))
            .check(RecyclerViewItemCountAssertion(1))
    }

}