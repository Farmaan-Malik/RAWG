package com.example.rawg.presentation.creatorScreen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.rawg.data.remote.responses.creators.Game
import com.example.rawg.data.remote.responses.creators.Position
import com.example.rawg.presentation.creatorScreen.CreatorScreenViewModel
import com.example.rawg.presentation.ui.theme.kdam
import com.example.rawg.presentation.ui.theme.oswald


@Composable
fun CreatorCard(
    games: List<Game>,
    games_count: Int,
    id: Int,
    image: String,
    image_background: String,
    name: String,
    positions: List<Position>,
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .wrapContentSize(Alignment.BottomCenter)
//        .clickable { navigate() }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
//                .padding(top = 16.dp)
                .height(200.dp)
                .fillMaxHeight(),
            contentAlignment = Alignment.CenterStart
        ) {
        Image(
            modifier = Modifier
                    .fillMaxSize()
//                .fillMaxHeight(1f)
                .aspectRatio(1f)
                .clip(RoundedCornerShape(20)),
            painter = rememberAsyncImagePainter(image),
            contentDescription = "${name} Image",
            contentScale = ContentScale.Crop
        )
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
//            modifier = Modifier.padding(start = 16.dp),
            fontWeight = FontWeight.Normal,
            fontSize = 25.sp,
            fontFamily = oswald,
            color = Color.Black,
//            textAlign = TextAlign.Center
        )
//                    Text(text = name, color = Color.DarkGray)

                }
            }
    }
}

}
