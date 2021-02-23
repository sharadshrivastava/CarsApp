package com.test.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class RegistrationsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        private var instance: RegistrationsApp? = null
        fun get(): RegistrationsApp? = instance
    }
}