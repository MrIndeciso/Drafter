package com.mrindeciso.util.db.dao

import androidx.room.*
import com.mrindeciso.util.data.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDAO {

    @Query("SELECT * FROM notes ORDER BY last_modified DESC")
    fun getAllNotes(): Flow<List<Note>>

    @Query("SELECT * FROM notes WHERE id=:id LIMIT 1")
    fun getNote(id: Int): Note

    @Insert
    fun insertNote(vararg note: Note)

    @Delete
    fun deleteNote(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateNote(note: Note)

}