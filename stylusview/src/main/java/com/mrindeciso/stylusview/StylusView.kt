package com.mrindeciso.stylusview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.icu.number.Scale
import android.util.AttributeSet
import android.view.DragEvent
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View

class StylusView : View {

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    var viewController: StylusViewInterface? = null

    private val scaleGestureDetector = ScaleGestureDetector(
        context,
        object: ScaleGestureDetector.SimpleOnScaleGestureListener() {
            override fun onScale(detector: ScaleGestureDetector?): Boolean {
                return if (detector != null && viewController != null) {
                    viewController!!.onScale(detector)
                } else {
                    false
                }
            }
        }

    )

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.let {
            viewController?.onDraw(it)
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if ((event?.pointerCount ?: 0) > 1)
            scaleGestureDetector.onTouchEvent(event)
        return if (event == null) {
            false
        } else if (!scaleGestureDetector.isInProgress && event.pointerCount == 1) {
            val result = viewController?.onTouchEvent(event) ?: true
            invalidate()
            result
        } else {
            invalidate()
            true
        }
    }

}