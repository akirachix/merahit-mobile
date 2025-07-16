package com.merahit.sokoconnect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.merahit.sokoconnect.ui.theme.SokoConnectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SokoConnectTheme {
            AppNavigation()
            }
        }
    }
}
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "welcome"
    ) {
        composable("welcome") {
            SokoConnectWelcomeScreen(
                navController = navController,
                screenNumber = 1,
                onNavigateNext = { navController.navigate("join") }
            )
        }
        composable("join") {
            JoinAsScreen(
                navController = navController,
                screenNumber = 2,
                onBuyerClick = { navController.navigate("services") },
                onVendorClick = { navController.navigate("services") }
            )
        }
        composable("services") {
            OurServicesScreen(
                navController = navController,
                screenNumber = 3,
                onNext = { navController.navigate("offer") }
            )
        }
        composable("offer") {
            WhatWeOfferScreen(
                navController = navController,
                screenNumber = 4,
                onGetStartedClick = { }
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun SokoConnectWelcomeScreenPreview() {
    SokoConnectTheme {
        SokoConnectWelcomeScreen(
            onNavigateNext = {},
            navController = rememberNavController(),
            screenNumber = 1
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OurServicesScreenPreview() {
    SokoConnectTheme {
    OurServicesScreen(
            onNext = {},
            navController = rememberNavController(),
            screenNumber = 2
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WhatWeOfferScreenPreview() {
    SokoConnectTheme {
    WhatWeOfferScreen(
            onGetStartedClick = {},
            navController = rememberNavController(),
            screenNumber = 3
        )
    }
}

@Preview(showBackground = true)
@Composable
fun JoinAsScreenPreview() {
    SokoConnectTheme {
        JoinAsScreen(
            onBuyerClick = {},
            onVendorClick = {},
            navController = rememberNavController(),
            screenNumber = 2
        )
    }
}
