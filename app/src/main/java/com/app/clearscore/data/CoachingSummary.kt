package com.app.clearscore.data


import com.google.gson.annotations.SerializedName

data class CoachingSummary(
    val activeChat: Boolean = false,
    val activeTodo: Boolean = false,
    val numberOfCompletedTodoItems: Int = 0,
    val numberOfTodoItems: Int = 0,
    val selected: Boolean = false
)