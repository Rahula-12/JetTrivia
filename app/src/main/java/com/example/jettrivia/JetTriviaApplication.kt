package com.example.jettrivia

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class JetTriviaApplication:Application() {

    override fun onCreate() {
        super.onCreate()
    }

}