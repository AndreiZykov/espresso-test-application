package com.andriizykov.espressotest.ui.task

import com.andriizykov.domain.Task
import com.andriizykov.espressotest.ui.BasePresenter
import com.andriizykov.espressotest.ui.BaseView
import io.reactivex.Observable

interface TasksViewContract {
    interface TasksView : BaseView {
        fun displayTasks(tasks: List<Task>)
        fun newTaskButtonClicks(): Observable<Unit>
        fun showToast(text: String)
    }

    interface TasksPresenter : BasePresenter<TasksView>
}