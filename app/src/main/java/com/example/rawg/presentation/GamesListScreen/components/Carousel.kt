package com.example.rawg.presentation.GamesListScreen.components

import android.view.Gravity.FILL
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerScope
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.airbnb.lottie.utils.MiscUtils.lerp
import com.example.rawg.presentation.GamesListScreen.GamesListViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Carousel(
    viewModel: GamesListViewModel = koinViewModel(),
    navHostController: NavHostController
) {
    val GameList by remember { viewModel.carouselState}


    val pagerState = rememberPagerState(
        initialPage = 1, initialPageOffsetFraction = 0f
    ) {
        GameList.size
    }
//    Text(text = "Featured Games")
    Box(modifier = Modifier
        .height(300.dp)){
        HorizontalPager(state = pagerState, pageSpacing = -210.dp) { index ->
            val pageOffset = (pagerState.currentPage - index) + pagerState.currentPageOffsetFraction
            val imageSize by animateFloatAsState(
                targetValue = if (pageOffset == 0.0f) 1f else .7f,
                animationSpec = tween(300),
                label = ""
            )
            val imagePosition by animateFloatAsState(targetValue = if (pageOffset != 0.0f) -200f else 1f)
            val imageIndex by animateFloatAsState(targetValue = if (pageOffset == 0.00f) 1f else 0f)

            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth(.7f)
                    .fillMaxHeight(1f)
                    .zIndex(imageIndex)
                    .clickable { navHostController.navigate("GameDetailScreen/${GameList[index].id}") }
//                    .fillMaxSize(.8f)
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .graphicsLayer {
                        scaleX = imageSize
                        scaleY = imageSize
                        translationX = imagePosition
                    },
                model = ImageRequest.Builder(LocalContext.current)
                    .data(GameList[index].background_image).build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,


                )

        }
    }
}