package com.example.dependencyinjectionstart.example2.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dependencyinjectionstart.R
import com.example.dependencyinjectionstart.example2.di.DaggerApplicationComponent
import javax.inject.Inject



class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: ExampleViewModel

    private val component by lazy {
        //***** Используем Builder для построения графа зависимостей *****
//        DaggerApplicationComponent
//            .builder()
//            .context(application)
//            .timeMillis(System.currentTimeMillis())
//            .build()
        //***** Используем Factory для построения графа зависимостей *****
        DaggerApplicationComponent.factory()
            .create(application, System.currentTimeMillis())
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.method()
    }
}