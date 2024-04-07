package com.example.taskandroid.ApiInstance

import com.example.taskandroid.ApiInstance.NetworkModule
import com.example.taskandroid.Dagger.DemoDagger2
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {


    fun inject(demoDagger2: DemoDagger2)


}