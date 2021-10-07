package com.mrindeciso.util.stylus

import android.graphics.Path
import com.mrindeciso.util.data.Line

object PathComposer {

    private const val INTERPOLATE_THRESHOLD = 25.0f

    fun convertLinesToPath(list: List<Line>): Path {
        val path = Path()

        if (list.isEmpty())
            return path

        path.moveTo(list.first().x, list.first().y)

        var dX = list.first().x
        var dY = list.first().y

        list.drop(1).forEach { line ->
            path.quadTo((dX + line.x)/2, (dY + line.y)/2, line.x, line.y)
            dX = line.x
            dY = line.y
        }

        return path
    }

}