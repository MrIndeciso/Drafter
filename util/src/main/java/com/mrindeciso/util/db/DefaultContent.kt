package com.mrindeciso.util.db

import android.graphics.Color
import com.mrindeciso.util.data.Brush
import com.mrindeciso.util.data.Shadow

object DefaultContent {

    val defaultBrushes: List<Brush> = listOf(
        Brush(color = Color.BLACK),
        Brush(color = Color.RED),
        Brush(color = Color.BLUE, enableDash = true),
        Brush(color = Color.YELLOW, alpha = 50, strokeStyle = Brush.StrokeStyle(width = 20.0f)),
        Brush(color = Color.WHITE),
        Brush(color = Color.BLACK, shadow = Shadow(5.0f, 10.0f, 10.0f, Color.GRAY))
    )

}