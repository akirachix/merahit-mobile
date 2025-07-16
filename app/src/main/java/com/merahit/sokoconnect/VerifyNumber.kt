package com.merahit.sokoconnect

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun VerifyYourNumber(
    navController: NavController,
    screenNumber: Int,
    imageId: Int,
    welcomeMessage:String){
    var pin1 by remember { mutableStateOf("") }
    var pin2 by remember { mutableStateOf("") }
    var pin3 by remember { mutableStateOf("") }
    var pin4 by remember { mutableStateOf("") }
    val modifier = Modifier
    Column(
        modifier = Modifier.run { fillMaxSize() },
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



                    })
        }

        Text(
            text = "Verify your number",
            modifier = Modifier.fillMaxWidth().padding(24.dp),
            fontSize = 24.sp,
            fontFamily = PersonalizedFont,
            textAlign = TextAlign.Center,
            color = Color(0xFF658F3D),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Please enter the code we sent on your number",
            modifier = Modifier.padding(24.dp, 0.dp, 24.dp, 0.dp),
            fontSize = 16.sp,
            fontFamily = PersonalizedFont,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(40.dp))

        Row( modifier = Modifier.fillMaxWidth(1f),
            horizontalArrangement = Arrangement.SpaceBetween){
            TextField(
                value = pin1,
                onValueChange = { pin1 = it },
                shape = RoundedCornerShape(16.dp),
                modifier = modifier.weight(1f)
                    .padding(16.dp, 0.dp, 16.dp, 0.dp)
                    .border(
                        width = 0.dp,
                        color = Color.White,
                    ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor =Color(0xFFC0F290),
                    unfocusedContainerColor = Color(0xFFC0F290),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent

                ),
                placeholder = {
                    Text("2",   style = TextStyle(
                        fontFamily = PersonalizedFont

                    ))
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )
            TextField(
                value = pin2,
                onValueChange = { pin2 = it },
                shape = RoundedCornerShape(16.dp),
                modifier = modifier.weight(1f)
                    .padding(16.dp, 0.dp, 16.dp, 0.dp)
                    .border(
                        width = 0.dp,
                        color = Color.White,
                    ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor =Color(0xFFC0F290),
                    unfocusedContainerColor = Color(0xFFC0F290),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                placeholder = {
                    Text("0",   style = TextStyle(
                        fontFamily = PersonalizedFont

                    ))
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )
            TextField(
                value = pin3,
                onValueChange = { pin3 = it },
                shape = RoundedCornerShape(16.dp),
                modifier = modifier.weight(1f)
                    .padding(16.dp, 0.dp, 16.dp, 0.dp)
                    .border(
                        width = 0.dp,
                        color = Color.White,
                    ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor =Color(0xFFC0F290),
                    unfocusedContainerColor = Color(0xFFC0F290),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                placeholder = {
                    Text("_")
                }
            )
            TextField(
                value = pin4,
                onValueChange = { pin4 = it },
                shape = RoundedCornerShape(16.dp),
                modifier = modifier.weight(1f)
                    .padding(16.dp, 0.dp, 16.dp, 0.dp)
                    .border(
                        width = 0.dp,
                        color = Color.White,
                    ),

                colors = TextFieldDefaults.colors(
                    focusedContainerColor =Color(0xFFC0F290),
                    unfocusedContainerColor = Color(0xFFC0F290),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent

                ),
                placeholder = {
                    Text("_")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier.run { fillMaxSize() },
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Text(
                text = "Didn’t receive code?",
                modifier = Modifier.padding(24.dp, 0.dp, 24.dp, 0.dp),
                fontSize = 16.sp,
                fontFamily = PersonalizedFont,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "Resend code",
                modifier = Modifier.padding(24.dp, 0.dp, 24.dp, 0.dp).clickable{navController.navigate("screen${screenNumber}")},
                fontSize = 16.sp,
                fontFamily = PersonalizedFont,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.height(220.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        if (screenNumber >= 1 && pin1.isNotEmpty()) {
                            navController.navigate("screen${screenNumber + 1}")
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF658F3D),
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Verify", modifier = Modifier.padding(56.dp, 8.dp),  style = TextStyle(
                        fontFamily = PersonalizedFont, fontSize = 16.sp

                    ))
                }
            }
        }

    }
}
