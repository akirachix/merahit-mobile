package com.merahit.sokoconnect
import androidx.compose.foundation.Image
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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun OurServicesScreen(
    onNext: () -> Unit = {},
    navController: NavController,
    screenNumber: Int,
) {
    var PersonalizedFont = FontFamily(
        Font(R.font.poppins)
    )

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(Modifier.height(60.dp))

            Image(
                painter = painterResource(id = R.drawable.market),
                contentDescription = "Market Icon",
                modifier = Modifier
                    .size(250.dp)
                    .offset(y = 25.dp)
            )
            Spacer(Modifier.height(48.dp))

            Text(
                text = "Our Services",
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp,
                color = Color.Black,
                fontFamily = PersonalizedFont,
                modifier = Modifier.offset(y = 50.dp)
            )

            Text(
                text = "Connecting our customers\nto Mama-Mbogas. Discover and order\nfresh, pre-prepared meals all in one\nconvenient platform.",
                fontSize = 19.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontFamily = PersonalizedFont,
                modifier = Modifier.offset(y = 70.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 28.dp, start = 32.dp, end = 32.dp)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Skip",
                fontSize = 25.sp,
                color = Color.Black,
                fontFamily = PersonalizedFont,
                modifier = Modifier
                    .clickable { navController.navigate("screen${screenNumber + 2}") }
            )

            Icon(
                painter = painterResource(id = R.drawable.outline_arrow_forward_24),
                contentDescription = "Next",
                tint = Color(0xFF4CAF50),
                modifier = Modifier
                    .size(32.dp)
                    .clickable { navController.navigate("offer") }
            )
        }
    }
}
