package com.example.rawg.presentation.stores.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun StoreGameCard(
     added: Int,
     name: String
) {
    Card(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .wrapContentSize(Alignment.BottomCenter)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .height(200.dp)
                .fillMaxHeight(),
            contentAlignment = Alignment.CenterStart
        ) {
//
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.5f)
                    .background(
                        brush = Brush.horizontalGradient(
                            listOf(
                                Color.White,
                                Color.Transparent
                            )
                        )
                    ),
                contentAlignment = Alignment.CenterStart
            ) {

                Column() {
                    Text(
                        text = name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        color = Color.DarkGray
                    )
                    Text(text = added.toString(), color = Color.DarkGray)
                }
            }
        }
    }
}
