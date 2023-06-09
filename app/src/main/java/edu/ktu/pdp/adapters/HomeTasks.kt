package edu.ktu.pdp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.ktu.pdp.R
import edu.ktu.pdp.models.Task

class HomeTasks(private val taskList: List<Task>)
    : RecyclerView.Adapter<HomeTasks.ViewHolder>(){

    private var listener:TaskAdapterInterface? = null
    fun setListener(listener: TaskAdapterInterface){
        this.listener = listener
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val description: TextView = view.findViewById(R.id.descriptiontv)

        init {
            view.findViewById<View>(R.id.deleteBtn).setOnClickListener {
                listener?.onDeleteItemClick(taskList[adapterPosition],adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.each_task, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = taskList[position]
        holder.description.text = data.description
    }

    interface TaskAdapterInterface{
        fun onDeleteItemClick(task: Task ,position: Int)
    }
}