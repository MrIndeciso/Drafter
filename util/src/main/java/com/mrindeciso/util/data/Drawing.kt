package com.mrindeciso.util.data

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
@JsonClass(generateAdapter = true)
data class Drawing (

    val brush: Brush,

    val lines: @RawValue MutableList<Line>

) : Parcelable