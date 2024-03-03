package com.example.rawg.presentation.creatorScreen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.rawg.data.remote.responses.creators.Game
import com.example.rawg.data.remote.responses.creators.Position
import com.example.rawg.presentation.ui.theme.oswald


@Composable
fun CreatorCard(
    games: List<Game>,
    games_count: Int,
    id: Int,
    image: String,
    image_background: String,
    name: String,
    slug: String,
    positions: List<Position>,
    navigate: () -> Unit
) {
    Card(
        modifier = Modifier
//            .fillMaxSize(.6f)
            .padding(16.dp)
            .clip(RoundedCornerShape(20))
            .wrapContentSize(Alignment.BottomCenter)
        .clickable { navigate() }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .height(200.dp)
                .fillMaxHeight(),
            contentAlignment = Alignment.CenterStart
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize(),
//                    .aspectRatio(),
//                    .clip(RoundedCornerShape(20)),
                painter = rememberAsyncImagePainter(image),
                contentDescription = "${name} Image",
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(1f),
                contentAlignment = Alignment.BottomStart
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(
                        text = name,
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                            .padding(start = 8.dp),
                        fontWeight = FontWeight.Normal,
                        fontSize = 25.sp,
                        fontFamily = oswald,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }

}
