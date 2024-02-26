package com.example.rawg.presentation.GamesListScreen.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter

@Composable
fun GameCard(
    name:String,
    id:Int,
    rating:Double,
    released:String,
    background_image:String,
//    dominant_color: String
//    navController: NavHostController,
   navigate: ()-> Unit
) {
    Card(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .wrapContentSize(Alignment.BottomCenter)
    ) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp)
            .height(200.dp)
            .fillMaxHeight(),
        contentAlignment = Alignment.CenterStart
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
//                .border(width = 5.dp, color = Color.Blue)
                .aspectRatio(1.5f),
            painter = rememberAsyncImagePainter(background_image),
            contentDescription = "${name} Image",
            contentScale = ContentScale.Crop
        )
        Column {
            Text(text = name, fontWeight = FontWeight.Bold, fontSize = 25.sp)
            Text(text = released)
            Row() {
                for (x in 1..rating.toInt()) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "",
                        Modifier
                            .shadow(elevation = 100.dp)
//                            .padding(top = 50.dp)
                            .background(
                                brush = Brush.radialGradient(
                                    colors = listOf(
                                        Color.Black,
                                        Color.Transparent
                                    )
                                )
                            )

                    )
                }
            }
        }
    }
}
}
