package com.mrindeciso.util.data

import android.graphics.Color
import android.graphics.Paint
import android.os.Parcelable
import androidx.annotation.ColorInt
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
@Entity(tableName = "brushes")
@JsonClass(generateAdapter = true)
data class Brush (

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "style")
    val style: @RawValue Style = Style.STROKE,

    @Embedded
    val strokeStyle: StrokeStyle = StrokeStyle(),

    @ColumnInfo(name = "anti_alias")
    val antialias: Boolean = true,

    @ColumnInfo(name = "color")
    @ColorInt val color: Int = Color.BLACK,

    @ColumnInfo(name = "alpha")
    val alpha: Int = 255,

    @Embedded
    val shadow: Shadow = Shadow.NO_SHADOW

    ) : Parcelable {

    enum class Style {
        STROKE,
        FILL,
        STROKEFILL;

        fun toPaintStyle() = when(this) {
            STROKE -> Paint.Style.STROKE
            FILL -> Paint.Style.FILL
            STROKEFILL -> Paint.Style.FILL_AND_STROKE
        }
    }

    @Parcelize
    @JsonClass(generateAdapter = true)
    data class StrokeStyle (

        @ColumnInfo(name = "joinstyle")
        val join: JoinStyle = JoinStyle.ROUND,

        @ColumnInfo(name = "width")
        val width: Float = 3.0f,

        @ColumnInfo(name = "cap")
        val cap: CapStyle = CapStyle.ROUND,

        @ColumnInfo(name = "miter")
        val miter: Float = 5.0f,

    ) : Parcelable {

        enum class JoinStyle {
            MITER,
            ROUND,
            BEVEL;

            fun toPaintJoinStyle() = when(this) {
                MITER -> Paint.Join.MITER
                ROUND -> Paint.Join.ROUND
                BEVEL -> Paint.Join.BEVEL
            }
        }

        enum class CapStyle {
            BUTT,
            ROUND,
            SQUARE;

            fun toPaintCapStyle() = when(this) {
                BUTT -> Paint.Cap.BUTT
                ROUND -> Paint.Cap.ROUND
                SQUARE -> Paint.Cap.SQUARE
            }
        }

    }

}
