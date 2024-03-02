package com.example.rawg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.rawg.presentation.GamesListScreen.GameScreen
import com.example.rawg.presentation.creatorScreen.CreatorScreen
import com.example.rawg.presentation.gameDetailScreen.GameDetailScreen
import com.example.rawg.presentation.ui.theme.RAWGTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RAWGTheme {

                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "GameScreen"){
                        composable("GameScreen"){
                            GameScreen(navController= navController)
                        }
                        composable("GameDetailScreen/{id}",
                            arguments = listOf(
                                navArgument("id"){
                                    type= NavType.IntType
                                }
                            )){
                            GameDetailScreen(id = it.arguments?.getInt("id")?: 0, navController = navController)
                        }
                        composable("CreatorScreen"){
                            CreatorScreen(navHostController = navController)
                        }

                }
            }
        }
    }
}

