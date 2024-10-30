package com.example.dependencyinjectionstart.example1

import dagger.Module
import dagger.Provides

@Module
class ComputerModule {

    @Provides
    fun providesMonitor():Monitor{
        return Monitor()
    }

    @Provides
    fun providesMemory(): Memory{
        return Memory()
    }

    @Provides
    fun providesProcessor():Processor{
        return Processor()
    }

    @Provides
    fun providesStorage(): Storage{
        return Storage()
    }

    @Provides
    fun providesComputerRower(
        storage: Storage,
        memory: Memory,
        processor: Processor
    ): ComputerTower{
        return ComputerTower(storage, memory, processor)
    }
}