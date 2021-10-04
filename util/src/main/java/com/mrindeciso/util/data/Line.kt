package com.mrindeciso.util.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Line (

    val x: Float,

    val y: Float,

)