package com.example.rawg.presentation.GamesListScreen.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
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
//    val color= "0xFF${dominant_color}"
    Log.e("LMAO2", id.toString() )
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 16.dp)
            .background(
                color = Color(0xFF00BE67),
                shape = RoundedCornerShape(corner = CornerSize(12.dp))
            )
            .fillMaxWidth()
            .fillMaxSize()
            .clickable { navigate()
//                navController.navigate("GameDetailScreen/{$id}")
                }
            .shadow(
                elevation = 10.dp,
                ambientColor = Color.Red

            )
    ) {
        Row(
            modifier = Modifier
                .height(250.dp)
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF00A1D5),
                            Color(0xFFF500BD),
                        ),
                    )
                ))
        {
            Image(
                painter = rememberAsyncImagePainter(background_image),
                contentDescription = null,
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth(.5f)
                    .fillMaxHeight(1f),
                contentScale = ContentScale.FillHeight
                //.aspectRatio(1f)
            )
            Column (modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                ){

                Text(name, fontSize = 25.sp, modifier = Modifier.padding(bottom = 10.dp))
                Text(text = released)
                Row {
                    for(x in 1.. rating.toInt()){
                        Icon(imageVector = Icons.Default.Star, contentDescription = "")
                    }
                }
            }

        }


    }
}