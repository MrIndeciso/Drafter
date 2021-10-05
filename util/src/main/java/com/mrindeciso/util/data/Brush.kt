package com.mrindeciso.util.data

import androidx.annotation.ColorInt
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@Entity(tableName = "brushes")
@JsonClass(generateAdapter = true)
data class Brush (

    @PrimaryKey(autoGenerate = true)
    val uid: Int,

    @ColumnInfo(name = "size")
    val size: Float,

    @ColumnInfo(name = "color")
    @ColorInt val color: Int,

    @ColumnInfo(name = "dashed")
    val dashed: Boolean,

    @ColumnInfo(name = "opacity")
    val opacity: Float,

)
