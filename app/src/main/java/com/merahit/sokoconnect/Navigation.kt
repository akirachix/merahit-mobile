package com.merahit.sokoconnect


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation(){
    val navController= rememberNavController()
    NavHost(navController=navController, startDestination = "screen1"){
        composable("screen1"){
            WelcomeScreen(navController=navController,  1, imageId = R.drawable.logo, welcomeMessage = "Sell your pre-prepared goods here")
        }
        composable("screen2"){
            SignUp(navController=navController,2, imageId = R.drawable.corner, welcomeMessage = "Sign up")
        }
        composable("screen3"){
            SignIn(navController=navController,3, imageId = R.drawable.corner, welcomeMessage = "Sign In")
        }
        composable("screen4"){
            ForgotPassword(navController=navController,4, imageId = R.drawable.corner, welcomeMessage = "Forgot password")
        }
        composable("screen5"){
            VerifyYourNumber(navController=navController,5, imageId = R.drawable.corner, welcomeMessage = "Verify your number")
        }
        composable("screen6"){
            ResetYourPassword(navController=navController,6, imageId = R.drawable.corner, welcomeMessage = "Reset your password")
        }
    }

}
