package com.example.rawg.presentation.gameDetailScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.rawg.R
import com.example.rawg.presentation.common.LoadingMain
import com.example.rawg.presentation.common.LoadingScreen
import com.example.rawg.presentation.common.MyAppBar
import com.example.rawg.presentation.ui.theme.kdam
import com.example.rawg.presentation.ui.theme.monserette
import com.example.rawg.presentation.ui.theme.oswald
import org.koin.androidx.compose.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameDetailScreen(
    viewModel: GameDetailScreenViewModel = koinViewModel(),
    id: Int, navController: NavHostController
) {

    val isLoading by remember { viewModel.isLoading }
    val scaffoldState = rememberBottomSheetScaffoldState()


    if (isLoading) {
        viewModel.getGameDetails(id)
        Box(modifier = Modifier.fillMaxSize()) {
            LoadingMain(loadingText = "Fetching Game Details", fontSize = 20f, 0f, 120f)
        }
    } else {

        BottomSheetScaffold(
            scaffoldState = scaffoldState,
            topBar = { MyAppBar(navController, "Game Details", null) },
            sheetPeekHeight = 270.dp,
            sheetContainerColor = Color(0xFF7360DF),
            sheetShape = AbsoluteRoundedCornerShape(15),
            sheetContent = {
                Box(modifier = Modifier.fillMaxSize()) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .clip(
                                RoundedCornerShape(15)
                            )
                            .background(
                                brush = Brush.verticalGradient(
                                    listOf(
                                        Color(0xFF7360DF),
//                            Color.White,
                                        Color(0xFFE5CFF7),
                                        Color(0xFFC499F3)
                                    )
                                )
                            )
                    ) {

                        Text(
                            text = "Description ",
                            fontSize = 23.sp,
//                            textDecoration = TextDecoration.Underline,
                            fontWeight = FontWeight.Bold,
                            fontFamily = kdam,
                            color = Color.Black,
                            modifier = Modifier
                                .padding(horizontal = 20.dp)
                                .verticalScroll(ScrollState(0))
                        )
                        Text(
                            viewModel._gameDetails.description_raw,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = monserette,
//                            letterSpacing = 1.sp,
                            textAlign = TextAlign.Justify,
//                            lineHeight = 27.sp,
                            color = Color.Black,
                            modifier = Modifier
                                .padding(20.dp)
                                .verticalScroll(ScrollState(0))
                        )
                    }
                }
            })
        { PaddinValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                Color(0xFF7360DF),
                                Color(0xFF160735),
                                Color(0xFFC499F3)
                            )
                        )
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = rememberAsyncImagePainter(viewModel._gameDetails.background_image),
                    contentDescription = "${viewModel._gameDetails.name} Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clip(RoundedCornerShape(15))
                        .fillMaxHeight(.35f),
                    contentScale = ContentScale.FillBounds
                )
                Text(
                    viewModel._gameDetails.name,
                    modifier = Modifier
                        .padding(top = 8.dp),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFFE5CFF7)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Absolute.Left,
                    modifier = Modifier.padding(top = 10.dp)
                ) {
                    Text(
                        "Release Date: ", modifier = Modifier,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFFE5CFF7)
                    )
                    Text(
                        viewModel._gameDetails.released,
                        modifier = Modifier,
                        fontSize = 15.sp,
                        color = Color(0xFFE5CFF7),
                        fontWeight = FontWeight.Medium
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            "Rating: ", modifier = Modifier,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFFE5CFF7)
                        )
                        Text(
                            "${viewModel._gameDetails.rating}",
                            modifier = Modifier,
                            fontSize = 18.sp,
                            color = Color(0xFFE5CFF7),
                            fontWeight = FontWeight.Medium
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        for (x in 1..viewModel._gameDetails.rating.toInt()) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = null,
                                tint = Color(0xFFFFD700)
                            )
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .background(
                            Color(0xFFF2AFEF),
                            shape = RoundedCornerShape(80)
                        )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(state = ScrollState(0)),
                        horizontalArrangement = Arrangement.SpaceAround,
                    ) {
                        viewModel._gameDetails.tags.forEach { tag ->
                            Text(
                                tag.name, modifier = Modifier

                                    .padding(8.dp)
//                                    .border(.5.dp,Color.Gray, RoundedCornerShape(30))
                                    .padding(5.dp),
                                fontSize = 16.sp,
                                color = Color.Black
                            )
                        }
                    }
                }
            }
        }
    }
}
