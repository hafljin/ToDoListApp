package com.example.todolistapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(private val todoList: MutableList<Todo>) :
    RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val taskTitle: TextView = itemView.findViewById(R.id.taskTitle)
        val priorityText: TextView = itemView.findViewById(R.id.priorityTextView)
        val checkBox: CheckBox = itemView.findViewById(androidx.appcompat.R.id.checkbox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.listitems, parent, false)
        return TodoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val currentItem = todoList[position]
        holder.taskTitle.text = currentItem.taskName
        holder.priorityText.text = currentItem.priority
        holder.checkBox.text = currentItem.isChecked.toString()

        holder.checkBox.setOnCheckedChangeListener{ _, isChecked ->
            currentItem.isChecked = isChecked
        }
    }

    override fun getItemCount() = todoList.size

    fun addTask(todo: Todo) {
        todoList.add(todo)
        notifyItemInserted(todoList.size  - 1)
    }

    fun deleteTasks(checkedTasks:List<Todo>){
        todoList.removeAll(checkedTasks)
        notifyDataSetChanged()
    }

    fun checkedTasks():List<Todo>{
        return todoList.filter { it.isChecked }
    }
}