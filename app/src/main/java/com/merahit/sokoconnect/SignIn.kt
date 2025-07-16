package com.merahit.sokoconnect

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SignIn(
    navController: NavController,
    screenNumber: Int,
    imageId: Int,
    welcomeMessage:String
) {
    var fullname by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    val passwordsMatch = password == confirmPassword
    val modifier = Modifier

    Column(
        modifier = Modifier.run { fillMaxSize() },
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,

        ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = "a picture of vegetables",
            modifier = Modifier.size(140.dp)
                .padding(0.dp),
            contentScale = ContentScale.Fit

        )
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "a picture od soko connect logo",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.18f)
                .padding(0.dp),
            contentScale = ContentScale.Fit
        )
        Text(
            text = "Sign In",
            modifier = Modifier.fillMaxWidth().padding(24.dp),
            fontSize = 24.sp,
            fontFamily = PersonalizedFont,
            textAlign = TextAlign.Center,
            color = Color(0xFF658F3D),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Phone Number",
            modifier = Modifier.padding(24.dp, 16.dp, 0.dp, 0.dp),
            fontSize = 16.sp,
            fontFamily = PersonalizedFont,
            textAlign = TextAlign.Center,
        )
        TextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            modifier = modifier.fillMaxWidth()
                .padding(16.dp, 0.dp, 16.dp, 0.dp)
                .border(
                    width = 1.dp,
                    color = Color.Black,
                ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            placeholder = {
                Text("Enter your phone number",   style = TextStyle(
                    fontFamily = PersonalizedFont

                ))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone
            )
        )
        Text(
            text = "Password",
            modifier = Modifier.padding(24.dp, 16.dp, 0.dp, 0.dp),
            fontSize = 16.sp,
            fontFamily = PersonalizedFont,
            textAlign = TextAlign.Center,
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            modifier = modifier.fillMaxWidth()
                .padding(16.dp, 0.dp, 16.dp, 0.dp)
                .border(
                    width = 1.dp,
                    color = Color.Black,
                ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            placeholder = {
                Text("Enter your password",    style = TextStyle(
                    fontFamily = PersonalizedFont

                ))
            },
            visualTransformation = PasswordVisualTransformation()

        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ){
            Text(
                text = "Forgot password?",
                modifier = Modifier.padding(24.dp, 16.dp, 24.dp, 0.dp).clickable{navController.navigate("screen${screenNumber+1}")},
                fontSize = 12.sp,
                fontFamily = PersonalizedFont,
                textAlign = TextAlign.Center,
            )

        }
        Spacer(modifier = Modifier.height(60.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    if (screenNumber >= 1 && phoneNumber.isNotEmpty() && password.isNotEmpty()) {
                        navController.navigate("screen${screenNumber + 4}")
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF658F3D),
                    contentColor = Color.White
                )
            ) {
                Text(text = "Sign In", modifier = Modifier.padding(56.dp, 8.dp), style = TextStyle(
                    fontFamily = PersonalizedFont, fontSize = 16.sp

                ))
            }
        }
        ClickableText(
            text = buildAnnotatedString {
                append("Don't have an account? ")
                pushStringAnnotation(tag = "SIGN_UP", annotation = "sign_up")
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFF658F3D),
                        fontWeight = FontWeight.Bold,
                        fontFamily = PersonalizedFont


                    )
                ) {
                    append("Sign up")
                }
                pop()
            },
            modifier = Modifier
                .padding(24.dp, 16.dp, 24.dp, 0.dp)
                .fillMaxWidth(),
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 12.sp,
                fontFamily = PersonalizedFont,
                textAlign = TextAlign.Center,
                color = Color.Black // default text color
            ),
            onClick = { offset:Int ->
                val annotatedText = buildAnnotatedString {
                    append("Don't have an account? ")
                    pushStringAnnotation(tag = "SIGN_UP", annotation = "sign_up")
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFF658F3D),
                            fontWeight = FontWeight.Bold,
                            fontFamily = PersonalizedFont

                        )
                    ) {
                        append("Sign UP")
                    }
                    pop()
                }
                annotatedText.getStringAnnotations(tag = "SIGN_UP", start = offset, end = offset)
                    .firstOrNull()?.let {
                        navController.navigate("screen${screenNumber - 1}")
                    }
            }
        )


    }
}
