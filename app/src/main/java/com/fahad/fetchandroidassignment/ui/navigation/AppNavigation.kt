package com.fahad.fetchandroidassignment.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fahad.fetchandroidassignment.ui.screens.HomeScreen
import kotlinx.serialization.Serializable

@Composable
fun AppNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = HomeScreenRoute) {
        composable<HomeScreenRoute> {
            HomeScreen(
                viewModel = hiltViewModel()
            )
        }
    }
}

@Serializable
object HomeScreenRoute
