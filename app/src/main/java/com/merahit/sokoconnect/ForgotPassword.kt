package com.merahit.sokoconnect

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun ForgotPassword(
    navController: NavController,
    screenNumber: Int,
    imageId: Int,
    welcomeMessage:String
){
    var phoneNumber by remember { mutableStateOf("") }
    val modifier = Modifier
    Column(
        modifier = Modifier.run { fillMaxSize() },
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,

        ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
        ) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = "a picture of vegetables",
                modifier = Modifier
                    .size(140.dp)
                    .align(Alignment.CenterStart),
                contentScale = ContentScale.Fit
            )
            Image(
                painter = painterResource(id = R.drawable.outline_arrow_back_24),
                contentDescription = "back arrow",
                modifier = Modifier
                    .size(32.dp)
                    .align(Alignment.TopStart)
                    .offset(x = 16.dp, y = 24.dp)
                    .clickable{navController.navigate("screen${screenNumber-1}")


                    })
        }


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
            text = "Forgot Password?",
            modifier = Modifier.fillMaxWidth().padding(24.dp),
            fontSize = 24.sp,
            fontFamily = PersonalizedFont,
            textAlign = TextAlign.Center,
            color = Color(0xFF658F3D),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Enter your phone number to verify it’s you,and we will send you a one-time authorization code.",
            modifier = Modifier.padding(24.dp, 0.dp, 24.dp, 0.dp),
            fontSize = 16.sp,
            fontFamily = PersonalizedFont,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(40.dp))
        TextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            modifier = modifier.fillMaxWidth()
                .padding(16.dp, 0.dp, 16.dp, 0.dp)
                .border(
                    width = 0.dp,
                    color = Color.White,
                ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor =Color(0xFFC0F290),
                unfocusedContainerColor = Color(0xFFC0F290),
            ),
            placeholder = {
                Text("+254 |",   style = TextStyle(
                    fontFamily = PersonalizedFont

                ))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone
            )
        )
        Spacer(modifier = Modifier.height(120.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    if (screenNumber >= 1 && phoneNumber.isNotEmpty()) {
                        navController.navigate("screen${screenNumber + 1}")
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF658F3D),
                    contentColor = Color.White
                )
            ) {
                Text(text = "Send", modifier = Modifier.padding(56.dp, 8.dp), style = TextStyle(
                    fontFamily = PersonalizedFont, fontSize = 16.sp

                ))
            }
        }
    }
}