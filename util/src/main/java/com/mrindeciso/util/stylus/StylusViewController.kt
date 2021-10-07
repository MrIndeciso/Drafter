package com.mrindeciso.util.stylus

import android.graphics.Canvas
import android.view.DragEvent
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import androidx.lifecycle.LifecycleOwner
import com.mrindeciso.stylusview.StylusViewInterface
import com.mrindeciso.util.data.Brush
import com.mrindeciso.util.data.Drawing
import com.mrindeciso.util.data.Line
import com.mrindeciso.util.data.Note
import kotlinx.coroutines.*
import timber.log.Timber
import kotlin.math.abs

class StylusViewController (
    private val note: Note,
    private val lifeCycleScope: CoroutineScope
) : StylusViewInterface {

    lateinit var selectedBrush: Brush
    var isEntireLineEraser: Boolean = false

    private var canvasOffsetX = 0.0f
    private var canvasOffsetY = 0.0f
    private var canvasScaleFactor = 1.0f
    private var canvasScalePivotX = 0.0f
    private var canvasScalePivotY = 0.0f

    override fun onDraw(canvas: Canvas) {
        canvas.translate(-canvasOffsetX, -canvasOffsetY)

        canvas.scale(
            canvasScaleFactor,
            canvasScaleFactor,
        )

        Timber.e("$canvasScaleFactor, ${canvas.clipBounds.width()}, ${canvas.clipBounds.height()}, $canvasOffsetX, $canvasOffsetY, $canvasScalePivotX, $canvasScalePivotY")

        note.drawings.map { drawing ->
            PathComposer.convertLinesToPath(drawing.lines).let { path ->
                canvas.drawPath(
                    path,
                    drawing.brush.canvasBrush
                )
            }
        }
    }

    private var dragStartX = 0.0f
    private var dragStartY = 0.0f

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.getToolType(0) == MotionEvent.TOOL_TYPE_STYLUS) {
            if (isEntireLineEraser) {
                if (event.action == MotionEvent.ACTION_MOVE) {
                    note.drawings.removeAll {
                        it.lines.count { abs(it.x - event.x) < 30.0f && abs(it.y - event.y) < 30.0f } > 0
                    }
                }
            } else {
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        note.drawings.add(Drawing(
                            selectedBrush,
                            mutableListOf()
                        ))
                    }
                    MotionEvent.ACTION_MOVE -> {
                        note.drawings.last().lines.add(
                            Line(event.x + canvasOffsetX, event.y + canvasOffsetY)
                        )
                    }
                }
            }
        } else {
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    dragStartX = event.x
                    dragStartY = event.y
                }
                MotionEvent.ACTION_MOVE -> {
                    canvasOffsetX += dragStartX - event.x
                    canvasOffsetY += dragStartY - event.y
                    dragStartX = event.x
                    dragStartY = event.y
                }
            }
        }

        return true
    }

    override fun onScale(detector: ScaleGestureDetector): Boolean {
        canvasScaleFactor *= detector.scaleFactor

        canvasScaleFactor = canvasScaleFactor.coerceIn(0.1f, 10.0f)
        return true
    }

}