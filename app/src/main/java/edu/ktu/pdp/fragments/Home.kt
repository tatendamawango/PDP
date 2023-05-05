package edu.ktu.pdp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import edu.ktu.pdp.adapters.HomeTasks
import edu.ktu.pdp.databinding.FragmentHomeBinding
import edu.ktu.pdp.models.Task


class Home : Fragment() {
    private lateinit var adapter: HomeTasks
    private lateinit var taskList: MutableList<Task>
    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

        taskList.add(Task("Task 1",))
        taskList.add(Task("Task 2",))
        taskList.add(Task("Task 3",))
        taskList.add(Task("Task 4",))
        taskList.add(Task("Task 5",))
        taskList.add(Task("Task 6",))
        taskList.add(Task("Task 7",))
        taskList.add(Task("Task 8",))
        taskList.add(Task("Task 9",))
        taskList.add(Task("Task 10",))
    }

    private fun init() {
        binding.tasksRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        taskList = mutableListOf()
        adapter = HomeTasks(taskList)
        binding.tasksRecyclerView.adapter = adapter
    }

}