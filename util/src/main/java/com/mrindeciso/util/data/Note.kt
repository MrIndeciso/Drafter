package com.mrindeciso.util.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import java.sql.Timestamp

@Entity
@JsonClass(generateAdapter = true)
data class Note (

    @PrimaryKey(autoGenerate = true) val id: Int,

    val author: String,

    val created: Timestamp,

    var lastModified: Timestamp,

    var title: String,

    var subtitle: String,

    var category: String,

    val drawings: MutableList<Drawing>,

    val text: MutableList<TextInsert>,

)