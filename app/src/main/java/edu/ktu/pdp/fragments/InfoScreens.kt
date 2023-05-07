package edu.ktu.pdp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import edu.ktu.pdp.R
import edu.ktu.pdp.adapters.InfoScreensTasks
import edu.ktu.pdp.adapters.WorkerReminderTasks
import edu.ktu.pdp.databinding.FragmentInfoScreensBinding
import edu.ktu.pdp.models.Task

class InfoScreens : Fragment() {
    private lateinit var binding: FragmentInfoScreensBinding
    private lateinit var adapter: InfoScreensTasks
    private lateinit var taskList: MutableList<Task>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoScreensBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        taskList.add(Task("Info 1",))

        binding.floatingActionButton.setOnClickListener {
            taskList.add(Task("Info ${taskList.size + 1}"))
            adapter.notifyDataSetChanged()
        }

    }

    private fun init() {
        binding.tasksRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        taskList = mutableListOf()
        adapter = InfoScreensTasks(taskList)
        binding.tasksRecyclerView.adapter = adapter
    }
}

