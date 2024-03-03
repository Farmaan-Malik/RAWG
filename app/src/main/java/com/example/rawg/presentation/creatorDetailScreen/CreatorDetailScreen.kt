package com.example.rawg.presentation.creatorDetailScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.example.rawg.presentation.common.LoadingMain
import org.koin.androidx.compose.koinViewModel

@Composable
fun CreatorDetailScreen(
    viewModel: CreatorDetailViewModel = koinViewModel(),
    navHostController: NavHostController,
    id: Int
) {



    val isLoading by remember { viewModel.isLoading }


    viewModel.getCreatorDetails(id)
    if(isLoading){
        LoadingMain(
            loadingText = "Fetching Creator Details",
            fontSize = 20f,
            xOffset = 0f,
            yOffset = 120f
        )
    }
    else {
           // To be done


    }


}
