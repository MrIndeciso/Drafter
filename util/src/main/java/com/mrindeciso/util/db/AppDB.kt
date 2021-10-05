package com.mrindeciso.util.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mrindeciso.util.data.Brush
import com.mrindeciso.util.db.dao.BrushDAO

@Database(version = 1, entities = [Brush::class])
abstract class AppDB : RoomDatabase() {

    abstract fun brushDao(): BrushDAO

}