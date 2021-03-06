package com.app.clearscore.data


data class CoachingSummary(
    val activeChat: Boolean = false,
    val activeTodo: Boolean = false,
    val numberOfCompletedTodoItems: Int = 0,
    val numberOfTodoItems: Int = 0,
    val selected: Boolean = false
)