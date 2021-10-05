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

    var viewController: StylusViewInterface? = null

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.let {
            viewController?.onDraw(it)
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return if (event == null) {
            false
        } else {
            val result = viewController?.onTouchEvent(event) ?: true
            invalidate()
            result
        }
    }

    override fun onDragEvent(event: DragEvent?): Boolean {
        return if (event != null) {
            viewController?.onDragEvent(event) ?: true
        } else {
            super.onDragEvent(event)
        }
    }

}