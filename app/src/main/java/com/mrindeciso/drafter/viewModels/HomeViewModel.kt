package com.mrindeciso.drafter.viewModels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrindeciso.util.data.Note
import com.mrindeciso.util.repo.NotesRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val notesRepo: NotesRepo,
) : ViewModel() {

    val notes = notesRepo.allNotes

    fun newNote(title: String, subtitle: String, category: String) = viewModelScope.launch(Dispatchers.IO) {
        Note(
            0,
            "",
            title = title,
            subtitle = subtitle,
            category = category,
        ).let { it ->
            notesRepo.insertNote(it)
        }
    }

}