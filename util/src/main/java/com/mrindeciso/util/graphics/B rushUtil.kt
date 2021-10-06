package com.mrindeciso.util.graphics

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Path
import com.mrindeciso.util.data.Brush
import com.mrindeciso.util.stylus.PaintComposer

val brushPath = Path().apply {
    moveTo(.0f, 128.0f)
    lineTo(32.0f, 32.0f)
    lineTo(96.0f, 96.0f)
    lineTo(128.0f, 0.0f)
}

fun Brush.renderPreview(): Bitmap {
    val preview = Bitmap.createBitmap(128, 128, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(preview)
    canvas.drawPath(
        brushPath,
        PaintComposer.convertBrushToPaint(this)
    )
    return preview
}