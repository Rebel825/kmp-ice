package com.reach.kmp.ui.base.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

object AppPersent : ViewModel() {
    private val _persentState = MutableStateFlow(PresentState())
    var persentState: StateFlow<PresentState> = _persentState

    fun setPersentController(state: PresentState) {
        viewModelScope.launch {
            _persentState.emit(state)
        }
    }
}

val LocalAppState =
    staticCompositionLocalOf<AppState> {
        CompositionLocalUtil.noLocalProvidedFor("LocalAppState")
    }

@Composable
internal fun rememberAppState(navController: NavHostController = rememberNavController()): AppState =
    remember(navController) {
        AppState(
            navController = navController,
        )
    }

/**
 * AppState 存放 App 级生命周期通用状态
 *
 * 在这添加状态需要评审
 */
class AppState(
    val navController: NavHostController,
)

class PresentState(
    val isShow: Boolean = false,
    val onPressBack: (() -> Unit)? = null,
    val content: @Composable () -> Unit = {},
)

object CompositionLocalUtil {
    fun noLocalProvidedFor(name: String): Nothing {
        error("CompositionLocal $name not present")
    }
}
