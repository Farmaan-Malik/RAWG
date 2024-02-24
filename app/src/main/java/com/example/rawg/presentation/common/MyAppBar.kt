package com.example.rawg.presentation.common


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text

import androidx.compose.material.TopAppBar

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow


import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MyAppBar(){
   TopAppBar(backgroundColor = Color(0xFF001D31),
      title ={
         OutlinedText("DAWG")
      }
   )
}

