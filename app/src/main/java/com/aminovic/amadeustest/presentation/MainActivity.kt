package com.aminovic.amadeustest.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aminovic.amadeustest.presentation.screens.details.DetailsScreen
import com.aminovic.amadeustest.presentation.screens.home.HomeScreen
import com.aminovic.amadeustest.presentation.ui.theme.AmadeusTestTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmadeusTestTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { paddings ->
                    NavHost(
                        navController = navController,
                        startDestination = Screens.Home.route,
                        modifier = Modifier.padding(paddings)
                    ) {
                        composable(Screens.Home.route) {
                            HomeScreen(
                                navigateToDetails = { id ->
                                    navController.navigate(
                                        Screens.Details.route + "/$id"
                                    )
                                }
                            )
                        }
                        composable(
                            route = Screens.Details.route + "/{cityId}",
                            arguments = listOf(
                                navArgument("cityId") {
                                    type = NavType.IntType
                                }
                            )
                        ) {
                            val id = it.arguments?.getInt("cityId")!!
                            DetailsScreen(
                               cityId = id,
                                popup = { navController.popBackStack() }
                            )
                        }
                    }
                }
            }
        }
    }
}
