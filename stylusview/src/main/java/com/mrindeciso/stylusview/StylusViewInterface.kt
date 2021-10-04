package com.mrindeciso.stylusview

import android.graphics.Canvas
import android.view.DragEvent
import android.view.MotionEvent

interface StylusViewInterface {

    fun onDraw(canvas: Canvas)

    fun onTouchEvent(event: MotionEvent): Boolean

    fun onDragEvent(event: DragEvent): Boolean

}