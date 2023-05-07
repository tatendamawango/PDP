package edu.ktu.pdp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.ktu.pdp.models.Task
import edu.ktu.pdp.databinding.EachTaskBinding

class HomeTasks(private val taskList: List<Task>)
    : RecyclerView.Adapter<HomeTasks.TaskViewHolder>(){

    private  val TAG = "HomeTasks"
    private var listener:TaskAdapterInterface? = null
    fun setListener(listener: TaskAdapterInterface){
        this.listener = listener
    }

    class TaskViewHolder(val binding: EachTaskBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = EachTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        with(holder){
            with(taskList[position]){
                binding.descriptiontv.text = this.description

                Log.d(TAG, "onBindViewHolder: $this")
                binding.deleteBtn.setOnClickListener {
                    listener?.onDeleteItemClick(this, position)
                }
            }
        }
    }

    interface TaskAdapterInterface{
        fun onDeleteItemClick(task: Task ,position: Int)
    }
}