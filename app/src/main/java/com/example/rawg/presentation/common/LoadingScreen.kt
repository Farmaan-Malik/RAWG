package com.example.rawg.presentation.common


import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieClipSpec
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.rawg.R
import coil.compose.rememberAsyncImagePainter



@Composable
fun LoadingScreen (modifier: Modifier = Modifier, isLoading:Boolean) {
    //animation logic
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(
            R.raw.amogus)
    )


    val clipSpecs = LottieClipSpec.Progress(
        min =  0.0f,
        max =  0.9f
    )


    LottieAnimation(
        composition = composition,
        clipSpec = clipSpecs,
        modifier = modifier,
        iterations = if (isLoading)  LottieConstants.IterateForever else 3,
    )
}


