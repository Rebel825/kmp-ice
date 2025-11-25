package com.reach.kmp.feature.ice

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.reach.kmp.ui.base.common.LocalAppState
import kotlinx.serialization.Serializable
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Serializable
object RouteIceScreen

fun NavGraphBuilder.iceRoute() {
    composable<RouteIceScreen> {
        IceRoute()
    }
}

@Composable
private fun IceRoute() {
    IceScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun IceScreen(
    navController: NavController = LocalAppState.current.navController,
    viewModel: IceViewModel = koinViewModel(),
) {
    val state by viewModel.state.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text("Ice List") },
            navigationIcon = {
                IconButton(onClick = { navController.na() }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            },
        )

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(state.items) { item ->
                Text(item)
            }
        }
    }
}

@Composable
@Preview
private fun IceScreenPreview() {
    IceScreen()
}


