package com.example.rawg.presentation.common

import androidx.compose.foundation.background
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun Loading(){
    CircularProgressIndicator(modifier = Modifier.background(Color.Transparent), color = Color.DarkGray,
        progress = 2f)
}