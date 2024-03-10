package com.example.todolistapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    //初期化遅らせる
    private lateinit var addButton: Button
    private lateinit var todoAdapter: TodoAdapter
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addButton = findViewById<Button>(R.id.addButton)
        addButton.setOnClickListener{
            addTask()
        }

        todoAdapter = TodoAdapter(mutableListOf())
        val listView = findViewById<RecyclerView>(R.id.listView)
        listView.adapter = todoAdapter
        listView.layoutManager = LinearLayoutManager(this)
    }

    private fun addTask(){
//        タイトル
        val taskNameE = findViewById<EditText>(R.id.taskTitle)
        val taskName = taskNameE.text.toString()
//        期限
        val taskDeadLineE = findViewById<EditText>(R.id.taskDeadLine)
        val taskDeadLine = taskDeadLineE.text.toString()
        //        優先度
        val priorityE = findViewById<Spinner>(R.id.prioritySpinner)
        val priority = priorityE.selectedItem.toString()


        if(taskName.isNotEmpty() && taskDeadLine.isNotEmpty()) {
            val task = Todo(taskName,taskDeadLine,priority) //dataclass
            todoAdapter.addTask(task)
            taskNameE.text.clear() //clearはedittextのメソッド
            taskDeadLineE.text.clear()
        }
    }
}

/**
 * TodoAdaptor.kt のclassファイル
 * */
