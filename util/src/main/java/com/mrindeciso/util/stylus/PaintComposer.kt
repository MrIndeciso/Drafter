package com.mrindeciso.util.stylus

import android.graphics.Paint
import com.mrindeciso.util.data.Brush

class PaintComposer {

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

        return paint
    }

}