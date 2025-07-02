package com.merahit.sokoconnect

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import com.merahit.sokoconnect.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


var PersonalizedFont = FontFamily(
    Font(R.font.poppins)
)
@Composable
fun WelcomeScreen(
    navController: NavController,
    screenNumber: Int,
    imageId: Int,
    welcomeMessage:String
){
    Column(
        modifier = Modifier.run { fillMaxSize().padding(16.dp) },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,

        ) {
        Image(
            painter = painterResource(id = imageId), contentDescription = "a picture of vegetables",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.35f)
                .padding(48.dp),
            contentScale = ContentScale.Fit

        )
        Text(
            text = welcomeMessage,
            modifier = Modifier.padding(),
            fontSize = 24.sp,
            fontFamily = PersonalizedFont,
            textAlign = TextAlign.Center,
            color = Color(0xFF658F3D),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(32.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(0.40f)
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.peas),
                    contentDescription = "a picture of cereals",
                    modifier = Modifier.weight(1f),
                    contentScale = ContentScale.Fit
                )
                Text(
                    text = "cereals",
                    fontSize = 24.sp,
                    fontFamily = PersonalizedFont,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF658F3D),
                    fontWeight = FontWeight.Bold
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(0.40f)
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.tilapia),
                    contentDescription = "a picture of fried tilapia",
                    modifier = Modifier.weight(1f),
                    contentScale = ContentScale.Fit
                )
                Text(
                    text = "cereals",
                    fontSize = 24.sp,
                    fontFamily = PersonalizedFont,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF658F3D),
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Image(
            painter = painterResource(id = R.drawable.cabbage),
            contentDescription = "a picture of chopped cabbage",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.54f)
                .padding(24.dp),
            contentScale = ContentScale.Fit
        )
        Text(
            text = "Vegetables",
            modifier = Modifier.padding(),
            fontSize = 24.sp,
            fontFamily = PersonalizedFont,
            textAlign = TextAlign.Center,
            color = Color(0xFF658F3D),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = { if (screenNumber>=1){
            navController.navigate("screen${screenNumber+1}")
        }},  colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF658F3D),
            contentColor = Color.White    )) {
            Text(text="Get Started", modifier = Modifier.padding(40.dp,8.dp))
        }
    }

}

@Composable
fun SignUp(
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
            painter = painterResource(id = imageId), contentDescription = "a picture of vegetables",
            modifier = Modifier.size(140.dp)
                .padding(0.dp),
            contentScale = ContentScale.Fit

        )
        Image(
            painter = painterResource(id =R.drawable.logo),
            contentDescription = "a picture od soko connect logo",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.18f)
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
                Text("Enter your full name")
            }
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
                Text("Enter your phone number")
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
                Text("Create a password")
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
            placeholder = { Text("Confirm password") },
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
        Spacer(modifier = Modifier.height(50.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    if (screenNumber >= 1 && fullname.isNotEmpty() && phoneNumber.isNotEmpty() && password.isNotEmpty()) {
                        navController.navigate("screen${screenNumber + 5}")
                    }
//                    if (fullname.isEmpty()&& phoneNumber.isEmpty()&& password.isEmpty()){
//
//                        Text(
//
//                            text = "Passwords do not match",
//                            color = Color.Red,
//                            modifier = Modifier.padding(start = 16.dp)
//                        )
//                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF658F3D),
                    contentColor = Color.White
                )
            ) {
                Text(text = "Sign up", modifier = Modifier.padding(56.dp, 8.dp))
            }
        }
        ClickableText(
            text = buildAnnotatedString {
                append("Already have an account? ")
                pushStringAnnotation(tag = "SIGN_IN", annotation = "sign_in")
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFF658F3D),
                        fontWeight = FontWeight.Bold
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
                            fontWeight = FontWeight.Bold
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

    }

}



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
                Text("Enter your phone number")
            }
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
                Text("Enter your password")
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
                Text(text = "Sign In", modifier = Modifier.padding(56.dp, 8.dp),fontSize = 12.sp,)
            }
        }
        ClickableText(
            text = buildAnnotatedString {
                append("Don't have an account? ")
                pushStringAnnotation(tag = "SIGN_UP", annotation = "sign_up")
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFF658F3D),
                        fontWeight = FontWeight.Bold
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
                            fontWeight = FontWeight.Bold
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
                Text("Enter your phone number")
            }
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
                Text(text = "Send", modifier = Modifier.padding(56.dp, 8.dp),fontSize = 12.sp,)
            }
        }
    }
}

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
                ),
                placeholder = {
                    Text("2")
                }
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
                ),
                placeholder = {
                    Text("0")
                }
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

                    ),
                placeholder = {
                    Text("_")
                }
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
                    Text(text = "Verify", modifier = Modifier.padding(56.dp, 8.dp),fontSize = 12.sp,)
                }
            }
        }

    }
}

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

            Spacer(modifier = Modifier.height(20.dp))

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
                    Text("Enter your new password")
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
                    Text("Confirm your new password")
                },
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
                        text = "Reset",
                        modifier = Modifier.padding(56.dp, 8.dp),
                        fontSize = 12.sp,
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
                        Text(
                            text = "Successful!",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF658F3D)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.verified),
                            contentDescription = "a picture of verification",
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.18f)
                                .padding(0.dp),
                            contentScale = ContentScale.Fit
                        )

                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Your password was successfully changed",
                            fontSize = 16.sp,
                            color = Color.Black
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
                            Text("Back To Home")
                        }
                    }
                }
            }
        }
    }
}

