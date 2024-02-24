package com.example.rawg.presentation.GamesListScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import coil.compose.rememberAsyncImagePainter









@Composable
fun GameCard(
    name:String,
    id:Int,
    rating:Double,
    released:String,
    background_image:String,
    dominant_color: String
) {
    val color= "0xFF${dominant_color}"

    Card(
        modifier = Modifier
            .padding( vertical = 8.dp)
            //.fillMaxWidth()
            .fillMaxSize()
            .border(5.dp, shape = RectangleShape,
                color = Color(0xFF00BE67)),
    ) {
        Row(
            modifier = Modifier.height(250.dp)
                .fillMaxSize())
                {
            Image(
                painter = rememberAsyncImagePainter(background_image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(.5f)
                    .fillMaxHeight(.8f),
                contentScale = ContentScale.FillHeight
                    //.aspectRatio(1f)
            )
            Text(name)
             }


    }
}