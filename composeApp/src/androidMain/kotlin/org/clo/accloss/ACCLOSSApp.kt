package org.clo.accloss

import android.app.Application
import org.clo.di.androidModule
import org.clo.di.core.Koin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class ACCLOSSApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Koin.koinConfiguration(additionalModules = listOf(androidModule)) {
            androidContext(this@ACCLOSSApp)
            androidLogger()
        }
    }
}
