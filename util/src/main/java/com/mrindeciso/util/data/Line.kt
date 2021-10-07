package com.mrindeciso.util.data

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Line (

    val x: Float,

    val y: Float,

) : Parcelable