package com.example.richorbroke

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.richorbroke.presenter.landingScreen.composables.LandingScreen
import com.example.richorbroke.presenter.landingScreen.viewModel.LandingPageViewModel
import com.example.richorbroke.ui.theme.RichOrBrokeTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val landingViewModel : LandingPageViewModel by viewModels()

            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "landingScreen") {
                composable(route = "landingScreen") {
                    LandingScreen(navController = navController, viewModel = landingViewModel)
                }
            }
        }
    }
}