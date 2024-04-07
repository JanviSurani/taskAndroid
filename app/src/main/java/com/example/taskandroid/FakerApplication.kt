package com.example.taskandroid

import android.app.Application
import com.example.taskandroid.ApiInstance.ApplicationComponent
import com.example.taskandroid.ApiInstance.DaggerApplicationComponent
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FakerApplication: Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent= DaggerApplicationComponent.builder().build()

    }
}