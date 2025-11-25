package com.reach.kmp.feature.ice

import androidx.navigation.NavGraphBuilder
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Configuration
import org.koin.core.annotation.Module


@Module
@ComponentScan("com.reach.kmp.feature.ice")
class IceModule

fun NavGraphBuilder.iceRouteModule() {
    iceRoute()
}
