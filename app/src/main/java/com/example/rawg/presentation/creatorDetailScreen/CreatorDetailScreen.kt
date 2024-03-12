package com.example.rawg.presentation.creatorDetailScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.rawg.presentation.common.LoadingMain
import com.example.rawg.presentation.common.MyAppBar
import com.example.rawg.presentation.ui.theme.oswald
import org.koin.androidx.compose.koinViewModel

@Composable
fun CreatorDetailScreen(
    viewModel: CreatorDetailViewModel = koinViewModel(),
    navHostController: NavHostController,
    id: Int
) {


    val isLoading by remember { viewModel.isLoading }
    viewModel.getCreatorDetails(id)

    if (isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            LoadingMain(
                loadingText = "Fetching Creator Details",
                fontSize = 20f,
                xOffset = 0f,
                yOffset = 120f
            )
        }
    } else {
        Scaffold(
            topBar = { MyAppBar(navHostController = navHostController, title = "Creator Detail", color = null)}
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = paddingValues.calculateTopPadding())
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = rememberAsyncImagePainter(viewModel.creatorDetails.image),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxHeight(.4f)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10)),
                    contentScale = ContentScale.FillBounds
                )
                Text(
                    text = viewModel.creatorDetails.name,
//                    modifier = Modifier.padding(top = 8.dp),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    text = "Game Count: ${viewModel.creatorDetails.games_count.toString()}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(top = 5.dp)

                )

                Text(
                    text = "Last Updated: ${viewModel.creatorDetails.updated}",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(bottom = 8.dp)
                )

                Column(
                    modifier = Modifier
                        .verticalScroll(
                            enabled = true,
                            state = ScrollState(0),
                            reverseScrolling = true,
                        )
                        .fillMaxHeight()
                        .padding(top = 16.dp)
                        .clip(RoundedCornerShape(10))
                        .background(Color.LightGray)
                ) {
                    Text(
                        text = viewModel.creatorDetails.description,
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .padding(bottom = 8.dp, top = 8.dp),
                        textAlign = TextAlign.Justify,
                        fontFamily = oswald,
                        fontSize = 20.sp,
                        lineHeight = 30.sp
                    )
                }

            }

            }

        }
    }

