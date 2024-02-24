package com.example.rawg.presentation.gameDetailScreen

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rawg.presentation.common.LoadingScreen
import org.koin.androidx.compose.koinViewModel


@Composable
fun GameDetailScreen(viewModel: GameDetailScreenViewModel = koinViewModel(), id:Int){

//    viewModel.setId(id)

    val isLoading by remember{viewModel.isLoading}
    Log.e("LMAO3",id.toString() )
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
        Text(text = viewModel._gameDetails.description_raw)
    }
}