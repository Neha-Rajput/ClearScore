package com.app.clearscore.di

import com.app.bbcapp.network.ApiInterface
import com.app.clearscore.ui.viewModel.MainViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://android-interview.s3.eu-west-2.amazonaws.com/"

val netModule = module {
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).client(client).build()
    }

    single { provideOkHttpClient() }
    single { provideRetrofit(get()) }
}


@InternalCoroutinesApi val viewModelScope = module {
    viewModel { MainViewModel(get()) }
}

val apiModule = module {

    fun provideUserApi(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }
    single { provideUserApi(get()) }
}