package com.example.todolistapp

data class Todo(
    val taskName: String,
    val taskDeadLine: String,
    val priority: String,
    var isChecked: Boolean = false
)
