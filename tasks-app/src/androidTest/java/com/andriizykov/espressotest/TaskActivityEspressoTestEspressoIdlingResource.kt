package com.andriizykov.espressotest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.andriizykov.espressotest.ui.task.TaskActivity
import com.andriizykov.espressotest.util.EspressoIdlingResource
import com.andriizykov.espressotest.util.RecyclerViewItemCountAssertion
import org.hamcrest.core.StringContains.containsString
import org.junit.Rule
import org.junit.Test


class TaskActivityEspressoTestEspressoIdlingResource {

    @get:Rule
    val activityRule = ActivityTestRule<TaskActivity>(TaskActivity::class.java)

    @Test
    fun screenHasNewTasksButtonAndItIsVisible() {
        onView(withId(R.id.new_task_button))
            .check(matches(isDisplayed()))
    }

    @Test
    fun tasksRepoReturns3Tasks_recyclerViewShouldHave3tasks() {
        onView(withId(R.id.recycler_view))
            .check(RecyclerViewItemCountAssertion(3))
    }

    @Test
    fun tasksRepoReturns3TasksAndWeAdd1More_recyclerViewShouldHave4tasks() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlingResource)
        // when
        onView(withId(R.id.new_task_button)).perform(click())
        // then
        onView(withId(R.id.recycler_view)).check(RecyclerViewItemCountAssertion(4))
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.countingIdlingResource)
    }

}