package com.mrindeciso.util.stylus

import android.graphics.Canvas
import android.view.DragEvent
import android.view.MotionEvent
import com.mrindeciso.stylusview.StylusViewInterface
import com.mrindeciso.util.data.Brush
import com.mrindeciso.util.data.Drawing
import com.mrindeciso.util.data.Line
import com.mrindeciso.util.data.Note

class StylusViewController (
    private val note: Note,
) : StylusViewInterface {

    lateinit var selectedBrush: Brush

    override fun onDragEvent(event: DragEvent): Boolean {
        return true
    }

    override fun onDraw(canvas: Canvas) {
        note.drawings.forEach { drawing ->
            canvas.drawPath(
                PathComposer.convertLinesToPath(drawing.lines),
                PaintComposer.convertBrushToPaint(drawing.brush),
            )
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                note.drawings.add(Drawing(
                    selectedBrush,
                    mutableListOf()
                ))
            }
            MotionEvent.ACTION_MOVE -> {
                note.drawings.last().lines.add(
                    Line(event.x, event.y)
                )
            }
        }

        return true
    }

}