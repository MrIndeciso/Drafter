package com.mrindeciso.util.data

import android.graphics.Color
import android.os.Parcelable
import androidx.annotation.ColorInt
import androidx.room.ColumnInfo
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Shadow (

    @ColumnInfo(name = "radius")
    val radius: Float,

    @ColumnInfo(name = "dx")
    val dx: Float,

    @ColumnInfo(name = "dy")
    val dy: Float,

    @ColumnInfo(name = "scolor")
    @ColorInt val shadowColor: Int,

) : Parcelable {

    companion object {

        val NO_SHADOW = Shadow(.0f, .0f, .0f, Color.BLACK)

    }

}