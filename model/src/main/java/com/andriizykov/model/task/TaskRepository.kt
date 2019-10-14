package com.andriizykov.model.task

import com.andriizykov.domain.Task
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.subjects.BehaviorSubject
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class TaskRepository @Inject constructor() : TaskDataSource {

    private val tasks = BehaviorSubject.createDefault(TASKS)

    override fun whenTasksChanged(): Observable<List<Task>> = tasks

    override fun newTask(task: Task): Single<Unit> {
        return Single.create<Unit> { emitter ->
            val taskList = tasks.value?.toMutableList() ?: mutableListOf()
            taskList.add(task)
            tasks.onNext(taskList)
            emitter.onSuccess(Unit)
        }.delaySubscription(3000L, TimeUnit.MILLISECONDS)
    }

    companion object {
        private val TASK_1 = Task("Learn Espresso Tests")
        private val TASK_2 = Task("Practice Espresso Tests")
        private val TASK_3 = Task("Write Espresso Tests")
        private val TASKS = listOf(TASK_1, TASK_2, TASK_3)
    }

}