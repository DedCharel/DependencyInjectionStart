package com.example.dependencyinjectionstart.example2.di

import com.example.dependencyinjectionstart.example2.data.datasource.ExampleLocalDataSource
import com.example.dependencyinjectionstart.example2.data.datasource.ExampleLocalDataSourceImpl
import com.example.dependencyinjectionstart.example2.data.datasource.ExampleRemoteDataSource
import com.example.dependencyinjectionstart.example2.data.datasource.ExampleRemoteDataSourceImpl
import com.example.dependencyinjectionstart.example2.data.datasource.TestRemoteDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindLocalDataSource(impl: ExampleLocalDataSourceImpl): ExampleLocalDataSource

    @ApplicationScope
    @Binds
    @TestQualifier
    fun bindTestRemoteDataSource(impl: TestRemoteDataSourceImpl): ExampleRemoteDataSource

    @ApplicationScope
    @Binds
    @ProdQualifier
    fun bindRemoteDataSource(impl: ExampleRemoteDataSourceImpl): ExampleRemoteDataSource
}