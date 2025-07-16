package com.merahit.sokoconnect

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff



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
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { if (screenNumber>=1){
            navController.navigate("screen${screenNumber+1}")
        }},  colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF658F3D),
            contentColor = Color.White    )) {
            Text(text="Get Started", modifier = Modifier.padding(40.dp,8.dp),
                fontFamily = PersonalizedFont,
                fontSize = 16.sp)
        }
        Spacer(modifier = Modifier.height(32.dp))
    }

}

