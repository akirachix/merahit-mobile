package com.merahit.sokoconnect

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay


@Composable
fun SokoConnectWelcomeScreen(
    navController: NavController,
    screenNumber: Int,
    onNavigateNext: () -> Unit
) {
    var PersonalizedFont = FontFamily(
        Font(R.font.poppins)
    )
    LaunchedEffect(Unit) {
        delay(5000)
        onNavigateNext()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.welcome),
            contentDescription = "Vegetables Background",
            modifier = Modifier
                .height(3540.dp)
                .matchParentSize()
                .align(Alignment.BottomCenter),
            contentScale = ContentScale.Crop,
        )

        Box(
            modifier = Modifier
                .matchParentSize()
                .background(Color.Black.copy(alpha = 0.4f))
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.52f)
                .clip(
                    RoundedCornerShape(
                        bottomStart = 160.dp,
                        bottomEnd = 160.dp
                    )
                )
                .background(Color.White)
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(Modifier.height(32.dp))
            Image(
                painter = painterResource(id = R.drawable.ourlogo),
                contentDescription = "Soko Connect Logo",
                modifier = Modifier
                    .size(310.dp)
                    .offset(y = -55.dp)
            )
            Text(
                text = "Welcome",
                color = Color(0xFF4CAF50),
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp,
                fontFamily = PersonalizedFont,
                modifier = Modifier.offset(y = -95.dp)
            )
        }
    }
}