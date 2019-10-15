package com.andriizykov.espressotest.di

import com.andriizykov.domain.Task
import com.andriizykov.model.task.TaskDataSource
import dagger.Module
import dagger.Provides
import io.reactivex.Observable
import io.reactivex.Single
import org.mockito.Mockito
import org.mockito.Mockito.`when` as whenever

@Module
class MockModelModule {
    @Provides
    fun providesMockTaskDataSource(): TaskDataSource {
        val taskDataSource = Mockito.mock(TaskDataSource::class.java)
        whenever(taskDataSource.whenTasksChanged()).thenReturn(Observable.just(listOf(TASK_1)))
        whenever(taskDataSource.newTask(Task("New Task"))).thenReturn(Single.just(Unit))
        return taskDataSource
    }

    companion object {
        private val TASK_1 = Task("TASK_1")
    }
}