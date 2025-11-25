package com.reach.kmp.shared

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.reach.kmp.feature.compose.RouteScreenSample
import com.reach.kmp.feature.learn.LearnScreenSample
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Serializable
object RouteStart

fun NavGraphBuilder.startRoute(navController: NavController) {
    composable<RouteStart> {
        StartRoute(navController)
    }
}

@Composable
private fun StartRoute(navController: NavController) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .safeDrawingPadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Hello Compose ${composePlatform()}",
                modifier = Modifier.padding(top = 16.dp),
            )

            Row(
                modifier = Modifier.padding(top = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    imageVector = KotlinLogo,
                    contentDescription = "Kotlin logo",
                    modifier =
                        Modifier
                            .padding(top = 8.dp, start = 14.dp)
                            .width(64.dp)
                            .height(64.dp),
                )
                Spacer(modifier = Modifier.width(64.dp))
                Image(
                    painter = painterResource(Res.drawable.ic_cmp_logo),
                    contentDescription = "Compose multiplatform logo",
                    modifier =
                        Modifier
                            .width(86.dp)
                            .height(86.dp),
                )
            }

            MenusContent(navController)
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun MenusContent(navController: NavController) {
    FlowRow(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(top = 32.dp)
                .padding(horizontal = 32.dp),
        horizontalArrangement =
            Arrangement.spacedBy(
                space = 32.dp,
                alignment = Alignment.CenterHorizontally,
            ),
        verticalArrangement = Arrangement.spacedBy(32.dp),
    ) {
        Button(
            modifier = Modifier.padding(horizontal = 32.dp),
            onClick = { navController.navigate(LearnScreenSample) },
        ) {
            Text(text = stringResource(resource = Res.string.shared_learn_screen))
        }

        Button(
            modifier = Modifier.padding(horizontal = 32.dp),
            onClick = { navController.navigate(RouteScreenSample) },
        ) {
            Text(text = stringResource(resource = Res.string.shared_screen_sample))
        }
    }
}
