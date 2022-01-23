package com.app.clearscore

import androidx.multidex.MultiDexApplication
import com.app.clearscore.di.apiModule
import com.app.clearscore.di.netModule
import com.app.clearscore.di.viewModelScope
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class MyApplication : MultiDexApplication() {
    @InternalCoroutinesApi
    override fun onCreate() {
        super.onCreate()
        configureKoin()

    }

    @InternalCoroutinesApi
    private fun configureKoin() {
        startKoin {
            androidContext(this@MyApplication)
            modules(netModule, apiModule, viewModelScope)
        }
    }
}