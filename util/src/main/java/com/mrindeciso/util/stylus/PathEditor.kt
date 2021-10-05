package com.mrindeciso.util.stylus

import android.graphics.CornerPathEffect
import android.graphics.DashPathEffect
import android.graphics.Paint
import android.graphics.Path
import com.mrindeciso.util.pref.StylusPrefManager
import javax.inject.Inject

class PathEditor @Inject constructor(
    private val prefManager: StylusPrefManager
) {

    fun modifyPath(input: Paint): Paint {
        return if (prefManager.applyCornetPathEffect) {
            val effect = CornerPathEffect(30.0f)
            input.pathEffect = effect
            input
        } else
            input
    }

}