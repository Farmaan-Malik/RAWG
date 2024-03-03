package com.example.rawg.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun FloatingBar(navController: NavHostController, color: Color?) {
    BottomAppBar(
        modifier = Modifier
            .offset(x = 70.dp, y = -8.dp)
            .clip(RoundedCornerShape(80))
            .fillMaxWidth(.7f)
            .fillMaxHeight(.07f),
        containerColor = color ?: Color(0xFF392467)
    ) {
        NavigationBarItem(selected = navController.currentDestination?.route == "CreatorScreen",
            onClick = { navController.navigate("CreatorScreen") },
            icon = {
                Icon(imageVector = Icons.Default.Face, contentDescription = null)
            },
            colors = NavigationBarItemDefaults.colors(unselectedIconColor = Color.White)
        )
        NavigationBarItem(
            selected = navController.currentDestination?.route == "GameScreen",
            onClick = { navController.navigate("GameScreen") },
            icon = {
                Icon(imageVector = Icons.Default.Home, contentDescription = null)
            }, colors = NavigationBarItemDefaults.colors(unselectedIconColor = Color.White)
        )
        NavigationBarItem(
            selected = navController.currentDestination?.route == "StoreScreen",
            onClick = { navController.navigate("StoreScreen") },
            icon = {
                Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Stores")
            },
            colors = NavigationBarItemDefaults.colors(unselectedIconColor = Color.White)
        )

    }
}

