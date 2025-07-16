package com.merahit.sokoconnect

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun JoinAsScreen(
    onVendorClick: () -> Unit,
    onBuyerClick: () -> Unit,
    navController: NavController,
    screenNumber: Int,
) {

    var PersonalizedFont = FontFamily(
        Font(R.font.poppins))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F6F8)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.buying),
            contentDescription = "Market Image",
            modifier = Modifier
                .width(400.dp)
                .height(350.dp)
                .clip(RoundedCornerShape(bottomStart = 48.dp, bottomEnd = 48.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(32.dp))


        Text(
            text = "Join as",
            style = TextStyle(
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF39A441),
                fontFamily = PersonalizedFont,
            )
        )

        Spacer(modifier = Modifier.height(10.dp))


        Text(
            text = "Buyer to buy pre-prepared items\nor Vendor to sell your products",
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontFamily = PersonalizedFont
            ),
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(70.dp))


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(160.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFF4CAF50))
                        .clickable { onVendorClick() },
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.vendor),
                        contentDescription = "Vendor",
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Vendor",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF39A441),
                    fontSize = 20.sp,
                    fontFamily = PersonalizedFont
                )
            }


            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(160.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFFC6F7BE))
                        .clickable { onBuyerClick() },
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.buyer),
                        contentDescription = "Buyer",
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Buyer",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF39A441),
                    fontSize = 20.sp,
                    fontFamily = PersonalizedFont
                )
            }
        }
    }
}