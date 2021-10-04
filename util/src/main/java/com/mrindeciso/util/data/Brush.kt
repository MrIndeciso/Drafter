package com.mrindeciso.util.data

import androidx.annotation.ColorInt
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Brush (

    val size: Float,

    @ColorInt val color: Int,

)
