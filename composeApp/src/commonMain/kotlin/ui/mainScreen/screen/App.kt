package ui.mainScreen.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import data.repoImp.Test
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import kmmnewsapp.composeapp.generated.resources.Res
import kmmnewsapp.composeapp.generated.resources.compose_multiplatform
import org.koin.compose.KoinContext
import org.koin.compose.koinInject
import ui.mainScreen.viewmodels.HomeViewModels

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App(navHostController: NavHostController) {
    pre()

}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun pre() {
    KoinContext {
        MaterialTheme {
            GetNewsScreen()
        }
    }

}

