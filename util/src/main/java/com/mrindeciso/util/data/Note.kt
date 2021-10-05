package com.mrindeciso.util.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import java.util.*

@Parcelize
@Entity(tableName = "notes")
@JsonClass(generateAdapter = true)
data class Note (

    @PrimaryKey(autoGenerate = true) val id: Int = 0,

    @ColumnInfo(name = "author")
    val author: String,

    @ColumnInfo(name = "creation_time")
    val created: Date = Date(System.currentTimeMillis()),

    @ColumnInfo(name = "last_modified")
    val lastModified: Date = Date(System.currentTimeMillis()),

    @ColumnInfo(name = "last_opened")
    val lastOpened: Date = Date(System.currentTimeMillis()),

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "subtitle")
    val subtitle: String,

    @ColumnInfo(name = "category")
    val category: String = "",

    @ColumnInfo(name = "drawings")
    val drawings: @RawValue MutableList<Drawing> = mutableListOf(),

    @ColumnInfo(name = "text_insert")
    val text: @RawValue MutableList<TextInsert> = mutableListOf()

) : Parcelable