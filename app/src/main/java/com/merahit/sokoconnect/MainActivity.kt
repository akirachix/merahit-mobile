package com.merahit.sokoconnect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.merahit.sokoconnect.ui.theme.SokoConnectTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SokoConnectTheme {
                AppNavigation()
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    SokoConnectTheme  {
        WelcomeScreen(rememberNavController(),1,R.drawable.logo,"Sell your pre-prepared goods here")
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    SokoConnectTheme  {
        SignUp(rememberNavController(), 2, R.drawable.corner, "Sign up")
    }
}

@Preview(showBackground = true)
@Composable
fun SignInPreview(){
    SokoConnectTheme  {
        SignIn (rememberNavController(), 3, imageId = R.drawable.corner, "Sign In")
    }
}

@Preview(showBackground = true)
@Composable
fun ForgotPasswordPreview(){
    SokoConnectTheme  {
        ForgotPassword(rememberNavController(),4,R.drawable.corner,"Forgot password")
    }
}

@Preview(showBackground = true)
@Composable
fun VerifyYourNumberPreview(){
    SokoConnectTheme {
        VerifyYourNumber(rememberNavController(),5,R.drawable.corner,"Verify your number")
    }
}

@Preview(showBackground = true)
@Composable
fun ResetYourPasswordPreview(){
    SokoConnectTheme  {
        ResetYourPassword(rememberNavController(),6,R.drawable.corner,"Reset your password")
    }
}





