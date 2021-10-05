package com.mrindeciso.drafter.viewModels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.mrindeciso.util.data.Note
import com.mrindeciso.util.db.dao.NoteDAO
import com.mrindeciso.util.pref.StylusPrefManager
import com.mrindeciso.util.stylus.StylusViewController
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

@HiltViewModel
class DrawViewModel @Inject constructor (
    private val savedStateHandle: SavedStateHandle,
    private val noteDao: NoteDAO,
    private val stylusPrefManager: StylusPrefManager,
) : ViewModel() {

    private val note: Note
        get() = savedStateHandle.get<Note>("note")!!

    private var _stylusViewController: StylusViewController? = null

    val stylusViewController: StylusViewController
        get() =
            if (_stylusViewController != null)
                _stylusViewController!!
            else
                StylusViewController(
                    note, stylusPrefManager
                ).also {
                    _stylusViewController = it
                }

    suspend fun loadNote(noteid: Int) = withContext(Dispatchers.IO) {
        if (!savedStateHandle.contains("note")) {
            savedStateHandle.set("note", noteDao.getNote(noteid))
        }
    }

}