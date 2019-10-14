package com.andriizykov.espressotest.ui.task

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.andriizykov.domain.Task
import com.andriizykov.espressotest.R
import com.andriizykov.espressotest.groupie.TaskItem
import com.jakewharton.rxbinding3.view.clicks
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import dagger.android.AndroidInjection
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_task.*
import javax.inject.Inject

class TaskActivity : AppCompatActivity(), TasksViewContract.TasksView {

    @Inject
    lateinit var presenter: TasksViewContract.TasksPresenter

    private val groupAdapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = groupAdapter
        }

    }

    override fun newTaskButtonClicks(): Observable<Unit> {
        return new_task_button.clicks()
    }

    override fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        presenter.subscribe(this)
    }

    override fun onPause() {
        presenter.unsubscribe()
        super.onPause()
    }

    override fun displayTasks(tasks: List<Task>) {
        groupAdapter.updateAsync(tasks.map { TaskItem.of(it) })
    }

}
