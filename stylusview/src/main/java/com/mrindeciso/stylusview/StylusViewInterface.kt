package com.mrindeciso.stylusview

import android.graphics.Canvas
import android.view.DragEvent
import android.view.MotionEvent
import android.view.ScaleGestureDetector

interface StylusViewInterface {

    fun onDraw(canvas: Canvas)

    fun onTouchEvent(event: MotionEvent): Boolean

    fun onScale(detector: ScaleGestureDetector): Boolean

}