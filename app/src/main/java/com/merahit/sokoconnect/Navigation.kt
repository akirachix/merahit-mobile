package com.merahit.sokoconnect
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "screen1") {
        composable("screen1") {
            SokoConnectWelcomeScreen(
                onNavigateNext = { navController.navigate("screen2") },
                navController = navController,
                screenNumber = 1
            )
        }
        composable("screen3") {
            OurServicesScreen(
                onNext = { navController.navigate("screen3") },
                navController = navController,
                screenNumber = 2
            )
        }
        composable("screen4") {
            WhatWeOfferScreen(
                onGetStartedClick = { },
                navController = navController,
                screenNumber = 3
            )
        }
        composable("screen2") {
            JoinAsScreen(
                onBuyerClick = {navController.navigate("screen3")},
                onVendorClick = {},
                navController = rememberNavController(),
                screenNumber = 2
            )
        }
    }
}