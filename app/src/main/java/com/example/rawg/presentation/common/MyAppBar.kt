package com.example.rawg.presentation.common



import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun MyAppBar(navHostController: NavHostController){
   TopAppBar(backgroundColor =Color(0xFF311F5A),
      title ={
         OutlinedText("GamePortal", 25f,x = null,y = null)

      },
      navigationIcon = {
         if (navHostController.previousBackStackEntry != null){
            IconButton(onClick = {navHostController.popBackStack()}) {
              Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Go back", tint = Color.White)
            }
         }else{
           Box(contentAlignment = Alignment.Center) {
               Icon(
                  imageVector = Icons.Default.Home,
                  contentDescription = null,
                  tint = Color.White,
                  modifier = Modifier.padding(start = 16.dp)
               )
            }
         }
      }
   )
}

