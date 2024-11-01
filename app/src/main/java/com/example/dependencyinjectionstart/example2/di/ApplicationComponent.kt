package com.example.dependencyinjectionstart.example2.di

import android.content.Context
import com.example.dependencyinjectionstart.example2.data.database.ExampleDatabase
import com.example.dependencyinjectionstart.example2.data.network.ExampleApiService
import com.example.dependencyinjectionstart.example2.presentation.ExampleViewModel
import com.example.dependencyinjectionstart.example2.presentation.MainActivity
import com.example.dependencyinjectionstart.example2.presentation.MainActivity2
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, DomainModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun getViewModel(): ExampleViewModel

    fun getDatabase(): ExampleDatabase

    fun getApiService(): ExampleApiService

    fun inject(activity: MainActivity)

    fun inject(activity: MainActivity2)


    //***** Если мы хотим использовать Bulder *****
//    @Component.Builder
//    interface ApplicationComponentBuilder {
//
//        @BindsInstance
//        fun context(context: Context): ApplicationComponentBuilder
//
//        @BindsInstance
//        fun timeMillis(timeMillis: Long): ApplicationComponentBuilder
//
//        fun build(): ApplicationComponent
//    }

    //***** Если мы хотим использовать Factory *****
    @Component.Factory
    interface ApplicationComponentFactory {

        fun create(
            @BindsInstance context: Context,
            @BindsInstance timeMillis: Long

        ): ApplicationComponent
    }
}