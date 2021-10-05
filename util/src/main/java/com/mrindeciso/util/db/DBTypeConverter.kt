package com.mrindeciso.util.db

import androidx.room.TypeConverter
import com.mrindeciso.util.data.Drawing
import com.mrindeciso.util.data.TextInsert
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.util.*

object DBTypeConverter {

    private val moshi = Moshi.Builder().build()

    private val drawingAdapter: JsonAdapter<MutableList<Drawing>> =
        moshi.adapter(Types.newParameterizedType(MutableList::class.java, Drawing::class.java))

    private val textAdapter: JsonAdapter<MutableList<TextInsert>> =
        moshi.adapter(Types.newParameterizedType(MutableList::class.java, TextInsert::class.java))

    @TypeConverter
    fun dateToLong(date: Date): Long = date.time

    @TypeConverter
    fun longToDate(long: Long): Date = Date(long)

    @TypeConverter
    fun drawingListToString(drawings: MutableList<Drawing>): String
            = drawingAdapter.toJson(drawings)

    @TypeConverter
    fun stringToDrawingList(string: String): MutableList<Drawing>
            = drawingAdapter.fromJson(string) ?: mutableListOf()

    @TypeConverter
    fun textListToString(textInsert: MutableList<TextInsert>): String
            = textAdapter.toJson(textInsert)

    @TypeConverter
    fun stringToTextList(string: String): MutableList<TextInsert>
            = textAdapter.fromJson(string) ?: mutableListOf()

}