package com.mrindeciso.util.repo

import androidx.annotation.WorkerThread
import com.mrindeciso.util.data.Note
import com.mrindeciso.util.db.dao.NoteDAO
import javax.inject.Inject

class NotesRepo @Inject constructor(
    private val noteDao: NoteDAO
) {

    val allNotes = noteDao.getAllNotes()

    @WorkerThread
    suspend fun insertNote(vararg note: Note) = noteDao.insertNote(*note)

}