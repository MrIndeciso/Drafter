package com.mrindeciso.util

import android.graphics.Paint
import android.graphics.Path
import android.util.Log
import com.mrindeciso.util.data.Brush
import com.mrindeciso.util.data.Line
import timber.log.Timber

fun List<Line>.toPath(useQuad: Boolean = false): Path {
    val path = Path()

    if (this.isEmpty())
        return path

    path.moveTo(this[0].x, this[0].y)

    if (useQuad) {
        forEachIndexed { index, coord ->
            if (index != 0) {
                path.cubicTo(
                    (2 * get(index - 1).x + coord.x) / 3,
                    (2 * get(index - 1).y + coord.y) / 3,
                    (get(index - 1).x + 2 * coord.x) / 3,
                    (get(index - 1).y + 2 * coord.y) / 3,
                    coord.x,
                    coord.y
                )
            }
        }
    } else {
        forEach { coord ->
            path.lineTo(coord.x, coord.y)
        }
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