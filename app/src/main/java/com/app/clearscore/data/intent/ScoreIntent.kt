package com.app.clearscore.data.intent

import com.app.clearscore.core.IIntent

sealed class ScoreIntent : IIntent {
    object FetchData : ScoreIntent()
    object FetchDetails : ScoreIntent()
}