package com.app.bbcapp.network

import com.app.clearscore.data.Score
import retrofit2.http.GET

interface ApiInterface {

    @GET("endpoint.json")
    suspend fun getData(): Score

}