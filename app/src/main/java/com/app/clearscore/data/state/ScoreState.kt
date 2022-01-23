package com.app.clearscore.data.state

import com.app.clearscore.core.IState
import com.app.clearscore.data.Score

data class ScoreState(
     val score : Score = Score(),
     val isLoading : Boolean = false,
    val errorMessage: String? = null

):IState