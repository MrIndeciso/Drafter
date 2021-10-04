package com.mrindeciso.stylusview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.DragEvent
import android.view.MotionEvent
import android.view.View

class StylusView : View {

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    lateinit var viewController: StylusViewInterface

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.let {
            viewController.onDraw(it)
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return if (event == null) {
            false
        } else {
            val result = viewController.onTouchEvent(event)
            invalidate()
            result
        }
    }

    override fun onDragEvent(event: DragEvent?): Boolean {
        return if (event != null) {
            viewController.onDragEvent(event)
        } else {
            super.onDragEvent(event)
        }
    }

}