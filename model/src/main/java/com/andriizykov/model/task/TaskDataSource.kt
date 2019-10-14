package com.andriizykov.model.task

import com.andriizykov.domain.Task
import io.reactivex.Observable
import io.reactivex.Single

interface TaskDataSource {
    fun whenTasksChanged(): Observable<List<Task>>
    fun newTask(task: Task): Single<Unit>
}