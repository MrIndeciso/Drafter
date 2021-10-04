package com.mrindeciso.util

import android.graphics.Paint
import android.graphics.Path
import com.mrindeciso.util.data.Brush
import com.mrindeciso.util.data.Line

fun List<Line>.toPath(): Path {
    val path = Path()

    if (this.isEmpty())
        return path

    path.moveTo(this[0].x, this[0].y)

    forEach { coord ->
        path.lineTo(coord.x, coord.y)
    }

    return path
}

fun Brush.toPaint(): Paint {
    val paint = Paint()
    paint.color = this.color
    paint.strokeWidth = this.size
    paint.isAntiAlias = true
    paint.strokeJoin = Paint.Join.ROUND
    paint.style = Paint.Style.STROKE
    return paint
}