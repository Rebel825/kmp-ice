package com.reach.kmp.ui.base.common

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun IceTheme(
    colorScheme: ColorScheme,
    content: @Composable () -> Unit,
) {
    val appState: AppState = rememberAppState()

//    val marsColor: MarsColor =
//        remember(darkTheme) {
//            if (darkTheme) darkMarsColor() else lightMarsColor()
//        }

    MaterialTheme(colorScheme = colorScheme) {
        CompositionLocalProvider(
//            LocalMarsColor provides marsColor,
            LocalAppState provides appState,
//            LocalDarkTheme provides darkTheme,
        ) {
            content()
        }
    }
}

