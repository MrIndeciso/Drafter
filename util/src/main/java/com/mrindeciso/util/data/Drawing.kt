package com.mrindeciso.util.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Drawing (

    val brush: Brush,

    val lines: MutableList<Line>

)