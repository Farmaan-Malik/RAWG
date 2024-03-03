package com.example.rawg.presentation.stores.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rawg.presentation.ui.theme.monserette
import com.example.rawg.presentation.ui.theme.oswald

@Composable
fun StoreCard(
    games_count: Int,
    name: String,
    navigate: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(16.dp)
//            .fillMaxSize()
            .height(100.dp)
            .clip(RoundedCornerShape(20))
            .wrapContentSize(Alignment.BottomCenter)
            .clickable { navigate() }
    ) {

        Column(
            modifier = Modifier
//                .fillMaxHeight()
                .fillMaxSize(),
//                .fillMaxWidth(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = name,
                modifier = Modifier
                    .padding(bottom = 10.dp, start = 8.dp, end = 8.dp),
                fontWeight = FontWeight.Normal,
                fontSize = 25.sp,
                fontFamily = oswald,
                color = Color.Black,
                textAlign = TextAlign.Center
            )

            Text(
                text = "${games_count} Games",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = monserette
            )
        }
    }
}