package com.example.richorbroke.presenter.landingScreen.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.richorbroke.presenter.landingScreen.viewModel.LandingPageViewModel

@Composable
fun LandingScreen(
    navController: NavController,
    viewModel : LandingPageViewModel
) {
    val allCoins = viewModel.allCoins
    
    LazyColumn() {
        items(allCoins.value) { coin -> 
            Text(text = coin.name)
        }
    }
}