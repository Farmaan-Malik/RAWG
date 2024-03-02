package com.example.rawg.presentation.common

import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import kotlin.io.path.fileVisitor


@Composable
fun OutlinedText(text:String, fontSize: Float, x:Float?,y:Float?
) {
    Text(
        text = text,
        style = LocalTextStyle.current.merge(
            TextStyle(
                fontSize = fontSize.sp,
                letterSpacing = 12.sp
                ,brush = Brush.horizontalGradient(
                    listOf(
                        Color(0xFF00BE67),
                        Color(0xFF00A1D5),
                        Color(0xFFF500Bd),
                        Color(0xFFFF86C9)
                    )
                ),
                shadow = Shadow(color = Color.Black, offset = Offset(x?:15f, y?:15f),
                    blurRadius = 12f),

                drawStyle =
                Stroke(
                    width = 3f, join = StrokeJoin.Miter,
                    pathEffect = PathEffect.cornerPathEffect(
                        1f
                    )
                )

            )
        )
    )
}


