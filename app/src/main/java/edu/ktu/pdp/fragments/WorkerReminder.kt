package edu.ktu.pdp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import edu.ktu.pdp.R
import edu.ktu.pdp.adapters.HomeTasks
import edu.ktu.pdp.adapters.WorkerReminderTasks
import edu.ktu.pdp.databinding.FragmentWorkerReminderBinding
import edu.ktu.pdp.models.Task

class WorkerReminder : Fragment(), WorkerReminderTasks.TaskAdapterInterface {
    private lateinit var adapter: WorkerReminderTasks
    private lateinit var taskList: MutableList<Task>
    private lateinit var binding: FragmentWorkerReminderBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWorkerReminderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        taskList.add(Task("Reminder 1",))
        taskList.add(Task("Reminder 2",))
        taskList.add(Task("Reminder 3",))
        taskList.add(Task("Reminder 4",))
        taskList.add(Task("Reminder 5",))
        taskList.add(Task("Reminder 6",))
        taskList.add(Task("Reminder 7",))

    }

    private fun init() {
        binding.tasksRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        taskList = mutableListOf()
        adapter = WorkerReminderTasks(taskList)
        adapter.setListener(this)
        binding.tasksRecyclerView.adapter = adapter
    }

    override fun onDeleteItemClick(task: Task, position: Int) {
        taskList.removeAt(position)
        adapter.notifyItemRemoved(position)
    }

}