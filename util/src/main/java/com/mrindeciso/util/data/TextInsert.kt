package com.mrindeciso.util.data

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class TextInsert (

    val iX: Int,

    val iY: Int,

    val textSize: Float,

    val textStyle: String,

    val text: String,

) : Parcelable