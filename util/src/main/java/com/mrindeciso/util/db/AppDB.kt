package com.mrindeciso.util.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mrindeciso.util.data.Brush
import com.mrindeciso.util.data.Note
import com.mrindeciso.util.db.dao.BrushDAO
import com.mrindeciso.util.db.dao.NoteDAO

@Database(version = 1, entities = [Brush::class, Note::class])
@TypeConverters(DBTypeConverter::class)
abstract class AppDB : RoomDatabase() {

    abstract fun brushDao(): BrushDAO

    abstract fun noteDao(): NoteDAO

}