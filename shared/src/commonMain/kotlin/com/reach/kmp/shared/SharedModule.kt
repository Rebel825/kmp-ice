package com.reach.kmp.shared

import com.reach.kmp.feature.ice.IceModule
import com.reach.kmp.feature.learn.LearnModule
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module(
    includes = [
        LearnModule::class,
        IceModule::class,
    ],
)
@ComponentScan("com.mars.shared")
class SharedModule
