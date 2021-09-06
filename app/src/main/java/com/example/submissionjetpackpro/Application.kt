package com.example.submissionjetpackpro

import android.app.Application
import com.example.core.di.databaseModule
import com.example.core.di.networkModule
import com.example.core.di.repositoryModule
import com.example.submissionjetpackpro.di.useCaseModule
import com.example.submissionjetpackpro.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

@Suppress("unused")
class Application: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@Application)
            modules(
                    listOf(
                            databaseModule,
                            networkModule,
                            repositoryModule,
                            useCaseModule,
                            viewModelModule
                    )
            )
        }
    }
}