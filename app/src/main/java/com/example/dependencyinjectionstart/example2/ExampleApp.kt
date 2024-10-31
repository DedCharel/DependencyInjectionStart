package com.example.dependencyinjectionstart.example2

import android.app.Application
import com.example.dependencyinjectionstart.example2.di.DaggerApplicationComponent

class ExampleApp: Application() {

    val component by lazy {
        //***** Используем Builder для построения графа зависимостей *****
//        DaggerApplicationComponent
//            .builder()
//            .context(application)
//            .timeMillis(System.currentTimeMillis())
//            .build()
        //***** Используем Factory для построения графа зависимостей *****
        DaggerApplicationComponent.factory()
            .create(this, System.currentTimeMillis())
    }
}