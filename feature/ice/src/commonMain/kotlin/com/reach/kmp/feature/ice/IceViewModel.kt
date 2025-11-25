package com.reach.kmp.feature.ice

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.koin.android.annotation.KoinViewModel

@Immutable
data class IceState(
    val items: List<String> = emptyList(),
)

@KoinViewModel
internal class IceViewModel: ViewModel() {
    private val _state = MutableStateFlow(IceState())
    val state: StateFlow<IceState> = _state.asStateFlow()

    init {
        loadItems()
    }

    private fun loadItems() {
        _state.value = IceState(
            items = listOf("Ice Item 1", "Ice Item 2", "Ice Item 3"),
        )
    }

    fun onItemClick(item: String) {
        // Handle item click
    }
}
