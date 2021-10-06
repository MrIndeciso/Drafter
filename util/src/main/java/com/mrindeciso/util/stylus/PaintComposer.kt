package com.mrindeciso.util.stylus

import android.graphics.ComposePathEffect
import android.graphics.CornerPathEffect
import android.graphics.DashPathEffect
import android.graphics.Paint
import com.mrindeciso.util.data.Brush

object PaintComposer {

    fun convertBrushToPaint(input: Brush): Paint {
        val paint = Paint()

        paint.style = input.style.toPaintStyle()

        paint.strokeJoin = input.strokeStyle.join.toPaintJoinStyle()
        paint.strokeWidth = input.strokeStyle.width
        paint.strokeCap = input.strokeStyle.cap.toPaintCapStyle()
        paint.strokeMiter = input.strokeStyle.miter

        paint.isAntiAlias = input.antialias

        paint.color = input.color
        paint.alpha = input.alpha

        paint.setShadowLayer(input.shadow.radius, input.shadow.dx, input.shadow.dy, input.shadow.shadowColor)

        paint.pathEffect = when {
            input.enableDash && input.roundBrush ->
                ComposePathEffect(
                    DashPathEffect(floatArrayOf(input.dashStyle.off, input.dashStyle.on), input.dashStyle.phase),
                    CornerPathEffect(input.roundRadius)
                )
            input.roundBrush ->
                CornerPathEffect(input.roundRadius)
            input.enableDash ->
                DashPathEffect(floatArrayOf(input.dashStyle.off, input.dashStyle.on), input.dashStyle.phase)
            else ->
                paint.pathEffect
        }

        return paint
    }

}