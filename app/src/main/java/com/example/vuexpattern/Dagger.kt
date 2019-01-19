package com.example.vuexpattern

import android.app.Application

class Dagger: Application() {
    companion object {
        lateinit var component: SingletonComponent
            private set
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerSingletonComponent.builder()
            .build()
    }
}