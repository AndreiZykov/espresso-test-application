package com.andriizykov.espressotest.groupie

import android.widget.TextView
import com.andriizykov.domain.Task
import com.andriizykov.espressotest.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item

class TaskItem private constructor(private val task: Task): Item() {

    override fun getLayout(): Int = R.layout.item_task

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.root.apply {
            findViewById<TextView>(R.id.task_title).text = task.title
        }
    }

    override fun getChangePayload(newItem: com.xwray.groupie.Item<*>?): Any? = task

    companion object {
        @JvmStatic
        fun of(task: Task): TaskItem {
            return TaskItem(task)
        }
    }

}