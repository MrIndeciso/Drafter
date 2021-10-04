package com.mrindeciso.util.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TextInsert (

    val iX: Int,

    val iY: Int,

    val textSize: Float,

    val textStyle: String,

    val text: String,

)