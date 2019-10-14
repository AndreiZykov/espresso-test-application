package com.andriizykov.espressotest.ui.task

import com.andriizykov.domain.Task
import com.andriizykov.espressotest.util.EspressoIdlingResource
import com.andriizykov.espressotest.util.Logger
import com.andriizykov.model.task.TaskDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TasksPresenterImpl @Inject constructor(
    private val taskDataSource: TaskDataSource,
    private val logger: Logger
) : TasksViewContract.TasksPresenter {

    private val disposables = CompositeDisposable()

    override fun subscribe(view: TasksViewContract.TasksView) {

        view.newTaskButtonClicks()
            .doOnNext { EspressoIdlingResource.increment() }
            .flatMap { taskDataSource.newTask(Task("New Task")).toObservable() }
            .doOnNext { EspressoIdlingResource.decrement() }
            .subscribe({ view.showToast("New Task Created") }) { logger.e(it) }
            .addTo(disposables)

        taskDataSource.whenTasksChanged()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(view::displayTasks) { logger.e(it) }
            .addTo(disposables)

    }

    override fun unsubscribe() {
        disposables.clear()
    }

}