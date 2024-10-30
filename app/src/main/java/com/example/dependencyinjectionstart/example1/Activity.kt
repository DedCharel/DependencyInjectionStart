package com.example.dependencyinjectionstart.example1

import javax.inject.Inject

class Activity {
    // lateinit var computer:Computer
    @Inject
    lateinit var keyboard: Keyboard
    private val component = DaggerNewComponent.create()
    val mouse = component.getMouse()
    val monitor = component.getMonitor()

    //В настоящей Activity делаем это в OnCreate
    init {
        DaggerNewComponent.create().inject(this)
    }
}