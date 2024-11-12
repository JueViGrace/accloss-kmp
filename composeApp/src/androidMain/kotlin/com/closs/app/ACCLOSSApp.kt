package com.closs.app

import android.app.Application
import com.closs.app.di.appModule
import com.closs.core.di.KoinBuilder
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class ACCLOSSApp : Application() {

    override fun onCreate() {
        super.onCreate()

        KoinBuilder
            .addModule(appModule())
            .addConfig(appDeclaration = {
                androidContext(this@ACCLOSSApp)
                androidLogger(level = if (BuildConfig.DEBUG) Level.DEBUG else Level.NONE)
            })
            .build()
    }
}
