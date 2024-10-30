package com.example.dependencyinjectionstart.example1

import dagger.Component

@Component(modules = [ComputerModule::class])
interface NewComponent {

    fun getMonitor(): Monitor

    fun getMouse(): Mouse

    fun inject(activity: Activity)
}