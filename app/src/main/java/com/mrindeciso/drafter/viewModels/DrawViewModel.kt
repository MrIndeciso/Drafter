package com.mrindeciso.drafter.viewModels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrindeciso.util.data.Brush
import com.mrindeciso.util.data.Note
import com.mrindeciso.util.pref.StylusPrefManager
import com.mrindeciso.util.repo.BrushRepo
import com.mrindeciso.util.repo.NotesRepo
import com.mrindeciso.util.stylus.StylusViewController
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

@HiltViewModel
class DrawViewModel @Inject constructor (
    private val savedStateHandle: SavedStateHandle,
    private val notesRepo: NotesRepo,
    private val stylusPrefManager: StylusPrefManager,
    brushRepo: BrushRepo,
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
                    note, viewModelScope
                ).also {
                    _stylusViewController = it
                }

    val brushes: Flow<List<Brush>> = brushRepo.allBrushes

    suspend fun loadNote(noteid: Int) = withContext(Dispatchers.IO) {
        if (!savedStateHandle.contains("note")) {
            savedStateHandle.set("note", notesRepo.getNote(noteid))
        }
    }

    fun onPause() = viewModelScope.launch(Dispatchers.IO) {
        notesRepo.updateNote(note)
    }

}