package edu.ktu.pdp.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.textfield.TextInputEditText
import edu.ktu.pdp.R
import edu.ktu.pdp.adapters.HomeTasks
import edu.ktu.pdp.databinding.FragmentHomeBinding
import edu.ktu.pdp.models.Task


class Home : Fragment(), HomeTasks.TaskAdapterInterface {
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

        taskList.add(Task("Test"))
        taskList.add(Task("Test"))

        binding.floatingActionButton.setOnClickListener {
            val dialogView = LayoutInflater.from(context).inflate(R.layout.add_task_dialog, null)
            val taskDescriptionEditText = dialogView.findViewById<TextInputEditText>(R.id.task_description_edittext)
            val cancelButton = dialogView.findViewById<Button>(R.id.cancel_button)
            val addButton = dialogView.findViewById<Button>(R.id.add_button)

            val dialog = AlertDialog.Builder(context)
                .setView(dialogView)
                .create()

            cancelButton.setOnClickListener {
                dialog.dismiss()
            }

            addButton.setOnClickListener {
                val taskDescription = taskDescriptionEditText.text.toString()
                taskList.add(Task(taskDescription))
                adapter.notifyDataSetChanged()
                dialog.dismiss()
            }
            dialog.show()
        }

    }

    private fun init() {
        binding.tasksRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        taskList = mutableListOf()
        adapter = HomeTasks(taskList)
        adapter.setListener(this)
        binding.tasksRecyclerView.adapter = adapter

    }

    override fun onDeleteItemClick(task: Task, position: Int){
        taskList.removeAt(position)
        adapter.notifyDataSetChanged()
    }

}