package com.merahit.sokoconnect

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ResetYourPassword(
    navController: NavController,
    screenNumber: Int,
    imageId: Int,
    welcomeMessage:String
){
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    val passwordsMatch = password == confirmPassword
    var showSuccessPopup by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.outline_arrow_back_black),
                    contentDescription = "back arrow",
                    modifier = Modifier
                        .size(32.dp)
                        .align(Alignment.TopStart)
                        .offset(x = 16.dp, y = 32.dp)
                        .clickable {
                            navController.navigate("screen${screenNumber - 1}")
                        }
                )
            }

            Text(
                text = "Reset your password",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                fontSize = 24.sp,
                fontFamily = PersonalizedFont,
                textAlign = TextAlign.Center,
                color = Color(0xFF658F3D),
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))


            var passwordVisible by remember { mutableStateOf(false) }
            var confirmPasswordVisible by remember { mutableStateOf(false) }


            Text(
                text = "Please enter your new password",
                modifier = Modifier
                    .padding(24.dp, 0.dp, 24.dp, 0.dp)
                    .fillMaxWidth(),
                fontSize = 16.sp,
                fontFamily = PersonalizedFont,
                textAlign = TextAlign.Center,
            )

            Spacer(modifier = Modifier.height(40.dp))
            TextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 0.dp, 16.dp, 0.dp),
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFC0F290),
                    unfocusedContainerColor = Color(0xFFC0F290),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                placeholder = {
                    Text(
                        "Enter your new password",
                        style = TextStyle(fontFamily = PersonalizedFont)
                    )
                },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = image, contentDescription = if (passwordVisible) "Hide password" else "Show password")
                    }
                }
            )

            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 0.dp, 16.dp, 0.dp),
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFC0F290),
                    unfocusedContainerColor = Color(0xFFC0F290),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                placeholder = {
                    Text(
                        "Confirm your new password",
                        style = TextStyle(fontFamily = PersonalizedFont)
                    )
                },
                visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (confirmPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                    IconButton(onClick = { confirmPasswordVisible = !confirmPasswordVisible }) {
                        Icon(imageVector = image, contentDescription = if (confirmPasswordVisible) "Hide password" else "Show password")
                    }
                },
                isError = !passwordsMatch && confirmPassword.isNotEmpty()
            )




            Spacer(modifier = Modifier.height(170.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        if (passwordsMatch && password.isNotBlank()) {
                            showSuccessPopup = true
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF658F3D),
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = "Reset Password",
                        fontFamily = PersonalizedFont,
                        modifier = Modifier.padding(56.dp, 8.dp),
                        fontSize = 16.sp
                    )
                }
            }
        }

        if (showSuccessPopup) {
            Box(
                Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
            )

            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(
                        modifier = Modifier.padding(70.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.verified),
                            contentDescription = "a picture of verification",
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.18f)
                                .padding(0.dp),
                            contentScale = ContentScale.Fit
                        )
                        Text(
                            text = "Success!",
                            fontFamily = PersonalizedFont,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF658F3D)
                        )

                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Your password was successfully changed",
                            fontSize = 16.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            fontFamily = PersonalizedFont

                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(onClick = {
                            showSuccessPopup = false
                            navController.navigate("screen${screenNumber + 1}")
                        },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF658F3D),
                                contentColor = Color.White
                            )) {
                            Text("Back To Home",   style = TextStyle(
                                fontFamily = PersonalizedFont, fontSize = 16.sp

                            ))
                        }
                    }
                }
            }
        }
    }
}

