package com.app.clearscore

import androidx.multidex.MultiDexApplication
import com.app.clearscore.di.apiModule
import com.app.clearscore.di.netModule
import com.app.clearscore.di.viewModelScope
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class ClearScoreApplication : MultiDexApplication() {
    @InternalCoroutinesApi
    override fun onCreate() {
        super.onCreate()
        configureKoin()

    }

    @InternalCoroutinesApi
    private fun configureKoin() {
        startKoin {
            androidContext(this@ClearScoreApplication)
            modules(netModule, apiModule, viewModelScope)
        }
    }
}