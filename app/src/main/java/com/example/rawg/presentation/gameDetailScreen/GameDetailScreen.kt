package com.example.rawg.presentation.gameDetailScreen

import android.util.Log
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.rawg.presentation.common.LoadingScreen
import org.koin.androidx.compose.koinViewModel


@Composable
fun GameDetailScreen
            (viewModel: GameDetailScreenViewModel = koinViewModel(),
             id:Int, navController: NavHostController){

    val isLoading by remember{viewModel.isLoading}
    viewModel.getGameDetails(id)
    if(isLoading){
        Box(modifier = Modifier.fillMaxSize()) {
            LoadingScreen(
                isLoading = isLoading, modifier = Modifier
                    .align(
                        Alignment.Center
                    )
                    .size(200.dp)
            )
        }
    }
    else
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
//            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberAsyncImagePainter(viewModel._gameDetails.background_image),
                contentDescription = "${viewModel._gameDetails.name} Image",
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp)
                    .fillMaxHeight(.6f)
                    .border(5.dp, Color.Black),
                contentScale = ContentScale.Fit
            )
            Text(
                viewModel._gameDetails.name,
                modifier = Modifier
//                        .fillMaxWidth()
                    .padding(top = 8.dp),
                fontSize = 25.sp,

                color = Color.DarkGray
            )
            Row(
//                Modifier.border(5.dp,Color.Blue)
            ) {
                Text("Rating: ${viewModel._gameDetails.rating}")

                for (x in 1..viewModel._gameDetails.rating.toInt()){
                    Icon(imageVector = Icons.Default.Star, contentDescription = null )

                }
                }
        }
        }
    }
