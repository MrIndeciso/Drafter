package com.mrindeciso.util.stylus

import android.graphics.Canvas
import android.graphics.Color
import android.view.DragEvent
import android.view.MotionEvent
import com.mrindeciso.stylusview.StylusViewInterface
import com.mrindeciso.util.data.Brush
import com.mrindeciso.util.data.Drawing
import com.mrindeciso.util.data.Line
import com.mrindeciso.util.data.Note
import com.mrindeciso.util.toPaint
import com.mrindeciso.util.toPath

class StylusViewController (
    val note: Note
) : StylusViewInterface {

    var currentDrawing: Int = 0

    override fun onDragEvent(event: DragEvent): Boolean {
        return true
    }

    override fun onDraw(canvas: Canvas) {
        note.drawings.forEach { drawing ->
            val path = drawing.lines.toPath()
            val paint = drawing.brush.toPaint()
            canvas.drawPath(path, paint)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                note.drawings.add(Drawing(
                    Brush(4.0f, Color.RED),
                    mutableListOf()
                ))
            }
            MotionEvent.ACTION_UP -> {
                currentDrawing += 1
            }
            MotionEvent.ACTION_MOVE -> {
                if (note.drawings.count() == currentDrawing) {
                    note.drawings.add(Drawing(
                        Brush(4.0f, Color.RED),
                        mutableListOf()
                    ))
                }

                note.drawings[currentDrawing].lines.add(
                    Line(event.x, event.y)
                )
            }
        }

        return true
    }

}