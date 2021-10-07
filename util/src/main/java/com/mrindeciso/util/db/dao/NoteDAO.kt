package com.mrindeciso.util.db.dao

import androidx.room.*
import com.mrindeciso.util.data.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDAO {

    @Query("SELECT * FROM notes ORDER BY last_modified DESC")
    fun getAllNotes(): Flow<List<Note>>

    @Query("SELECT * FROM notes WHERE id=:id LIMIT 1")
    suspend fun getNote(id: Int): Note

    @Insert
    suspend fun insertNote(vararg note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNote(note: Note)

}