package com.example.rawg.presentation.common

import android.widget.ProgressBar
import androidx.compose.foundation.background
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun Loading(){
    CircularProgressIndicator(modifier = Modifier.background(Color.Transparent), color = Color.DarkGray,
        progress = 0.5f, strokeWidth = 5.dp)
}