package edu.ktu.pdp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import edu.ktu.pdp.R
import edu.ktu.pdp.models.Task

class InfoScreensTasks(private val taskList: List<Task>)
    : RecyclerView.Adapter<InfoScreensTasks.ViewHolder>(){

    private var listener: TaskAdapterInterface? = null
    private var selectedItemPosition = RecyclerView.NO_POSITION
    fun setListener(listener: TaskAdapterInterface){
        this.listener = listener
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val description: TextView = view.findViewById(R.id.descriptiontv)
        private var isSelected: Boolean = false

        init {
            view.findViewById<View>(R.id.deleteBtn).setOnClickListener {
                listener?.onDeleteItemClick(taskList[adapterPosition],adapterPosition)
            }
            view.findViewById<View>(R.id.shownBtn).setOnClickListener {
                listener?.onShownItemClick(this@ViewHolder, adapterPosition)
            }
        }
        fun setSelected(isSelected: Boolean) {
            this.isSelected = isSelected
            if (isSelected) {
                itemView.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.green))
            } else {
                itemView.setBackgroundColor(ContextCompat.getColor(itemView.context, android.R.color.transparent))
            }
        }
    }

    fun setSelectedItem(position: Int) {
        val previousSelectedItemPosition = selectedItemPosition
        selectedItemPosition = position
        notifyItemChanged(previousSelectedItemPosition)
        notifyItemChanged(selectedItemPosition)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.each_ppt, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = taskList[position]
        holder.description.text = data.description
        holder.setSelected(selectedItemPosition == position)

        holder.itemView.setOnClickListener {
            val previousSelectedItemPosition = selectedItemPosition
            selectedItemPosition = if (selectedItemPosition == position) {
                RecyclerView.NO_POSITION
            } else {
                position
            }
            notifyItemChanged(previousSelectedItemPosition)
            notifyItemChanged(selectedItemPosition)
        }
    }

    interface TaskAdapterInterface{
        fun onDeleteItemClick(task: Task ,position: Int)
        fun onShownItemClick(holder: ViewHolder, position: Int)
    }

}