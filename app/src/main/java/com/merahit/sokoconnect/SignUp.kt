package com.merahit.sokoconnect

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SignUp(
    navController: NavController,
    screenNumber: Int,
    imageId: Int,
    welcomeMessage:String
) {
    val scrollState = rememberScrollState()
    var fullname by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    val passwordsMatch = password == confirmPassword
    val modifier = Modifier
    var checked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.run { fillMaxSize().verticalScroll(scrollState) },
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,

        ) {
        Image(
            painter = painterResource(id = imageId), contentDescription = "a picture of vegetables",
            modifier = Modifier.size(120.dp)
                .padding(0.dp),
            contentScale = ContentScale.Fit

        )
        Image(
            painter = painterResource(id =R.drawable.logo),
            contentDescription = "a picture od soko connect logo",
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(0.dp),
            contentScale = ContentScale.Fit
        )
        Text(
            text = "Sign up",
            modifier = Modifier.fillMaxWidth().padding(24.dp),
            fontSize = 24.sp,
            fontFamily = PersonalizedFont,
            textAlign = TextAlign.Center,
            color = Color(0xFF658F3D),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Full name",
            modifier = Modifier.padding(24.dp, 16.dp, 0.dp, 0.dp),
            fontSize = 16.sp,
            fontFamily = PersonalizedFont,
            textAlign = TextAlign.Center,
        )
        TextField(
            value = fullname,
            onValueChange = { fullname = it },
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
                Text("Enter your full name",   style = TextStyle(
                    fontFamily = PersonalizedFont

                ))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
        )
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
                Text("Enter your phone number",
                    style = TextStyle(
                        fontFamily = PersonalizedFont

                    ))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone
            )
        )
        Text(
            text = "Enter location",
            modifier = Modifier.padding(24.dp, 16.dp, 0.dp, 0.dp),
            fontSize = 16.sp,
            fontFamily = PersonalizedFont,
            textAlign = TextAlign.Center,
        )
        TextField(
            value = location,
            onValueChange = { location = it },
            modifier = modifier.fillMaxWidth()
                .padding(16.dp, 0.dp, 16.dp, 0.dp)
                .border(
                    width = 1.dp,
                    color = Color.Black,
                ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),   placeholder = {
                Text(
                    "Enter your location",
                    style = TextStyle(
                        fontFamily = PersonalizedFont

                    )
                )
            }
        )
        Text(
            text = "Create password",
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
                Text("Create a password",   style = TextStyle(
                    fontFamily = PersonalizedFont

                ))
            },
            visualTransformation = PasswordVisualTransformation()

        )

        Text(
            text = "Confirm password",
            modifier = Modifier.padding(24.dp, 16.dp, 0.dp, 0.dp),
            fontSize = 16.sp,
            fontFamily = PersonalizedFont,
            textAlign = TextAlign.Center,
        )
        TextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 0.dp, 16.dp, 0.dp)
                .border(
                    width = 1.dp,
                    color = Color.Black,
                ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            placeholder = { Text("Confirm password",   style = TextStyle(
                fontFamily = PersonalizedFont

            )) },
            visualTransformation = PasswordVisualTransformation(),
            isError = !passwordsMatch && confirmPassword.isNotEmpty()
        )

        if (!passwordsMatch && confirmPassword.isNotEmpty()) {
            Text(
                text = "Passwords do not match",
                color = Color.Red,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Checkbox(   modifier = Modifier.padding(start = 40.dp),
                checked = checked,
                onCheckedChange = { checked = it }
            )
            Text(
                text = "Agree to the Terms and Conditions",
                modifier = Modifier.padding( top = 16.dp),
                fontSize = 12.sp,
                fontFamily = PersonalizedFont,
                textAlign = TextAlign.Center,
            )
        }
        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    if (screenNumber >= 1 && fullname.isNotEmpty() && phoneNumber.isNotEmpty() && password.isNotEmpty()&& checked){
                        navController.navigate("screen${screenNumber + 5}")
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF658F3D),
                    contentColor = Color.White
                )
            ) {
                Text(text = "Sign up", modifier = Modifier.padding(56.dp, 8.dp),   style = TextStyle(
                    fontFamily = PersonalizedFont, fontSize = 16.sp

                ))
            }
        }
        ClickableText(
            text = buildAnnotatedString {
                append("Already have an account? ")
                pushStringAnnotation(tag = "SIGN_IN", annotation = "sign_in")
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFF658F3D),
                        fontWeight = FontWeight.Bold,
                        fontFamily = PersonalizedFont


                    )
                ) {
                    append("Sign in")
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
                color = Color.Black
            ),
            onClick = { offset:Int ->
                val annotatedText = buildAnnotatedString {
                    append("Already have an account? ")
                    pushStringAnnotation(tag = "SIGN_IN", annotation = "sign_in")
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFF658F3D),
                            fontWeight = FontWeight.Bold,
                            fontFamily = PersonalizedFont
                        )
                    ) {
                        append("Sign in")
                    }
                    pop()
                }
                annotatedText.getStringAnnotations(tag = "SIGN_IN", start = offset, end = offset)
                    .firstOrNull()?.let {
                        navController.navigate("screen${screenNumber + 1}")
                    }
            }
        )
        Spacer(modifier = Modifier.height(60.dp))

    }

}