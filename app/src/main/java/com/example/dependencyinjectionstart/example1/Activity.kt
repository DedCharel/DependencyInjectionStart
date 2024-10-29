package com.example.dependencyinjectionstart.example1

class Activity {
    lateinit var computer:Computer
    lateinit var keyboard: Keyboard

    //В настоящей Activity делаем это в OnCreate
    init {
       Component().inject(this)
    }
}