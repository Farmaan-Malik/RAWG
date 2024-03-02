package com.example.rawg.presentation.creatorScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.rawg.presentation.common.FloatingBar
import com.example.rawg.presentation.common.LoadingMain
import com.example.rawg.presentation.common.MyAppBar
import com.example.rawg.presentation.creatorScreen.component.CreatorCard
import org.koin.androidx.compose.koinViewModel


@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun CreatorScreen(viewModel: CreatorScreenViewModel = koinViewModel(),
                  navHostController: NavHostController) {

    val isLoading by remember {viewModel.isLoading }
    val Creatorlist by remember { viewModel.state }
    Scaffold(topBar = { MyAppBar(navHostController) }, modifier = Modifier.fillMaxSize(),
        bottomBar = {
            FloatingBar(
                navController = navHostController
            )
        }

    )
    { paddingValues ->
        when {
            isLoading -> {
                LoadingMain("Fetching Creator List..", 15f, 0f, 60f)
            }
            !isLoading ->{
                LazyVerticalGrid(modifier= Modifier.padding(top = paddingValues.calculateTopPadding()) ,columns = GridCells.Fixed(2)){
                    items(Creatorlist){
                        Creator->
                        Text(text = "C", fontSize = 30.sp, fontWeight = FontWeight.ExtraBold)

                        CreatorCard(
                            games = Creator.games,
                            games_count = Creator.games_count,
                            id = Creator.id,
                            image = Creator.image,
                            image_background = Creator.image_background,
                            name = Creator.name,
                            positions = Creator.positions
                        )
                    }

                }
            }
        }
    }
}
