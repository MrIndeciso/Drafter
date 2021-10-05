package com.mrindeciso.drafter.viewModels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.mrindeciso.util.data.Note
import com.mrindeciso.util.pref.StylusPrefManager
import com.mrindeciso.util.stylus.PathEditor
import com.mrindeciso.util.stylus.StylusViewController
import dagger.hilt.android.lifecycle.HiltViewModel
import java.sql.Timestamp
import javax.inject.Inject

@HiltViewModel
class DrawViewModel @Inject constructor (
    private val savedStateHandle: SavedStateHandle,
    stylusPrefManager: StylusPrefManager,
    pathEditor: PathEditor,
) : ViewModel() {

    val note = Note(
        0,
        "",
        Timestamp(System.currentTimeMillis()),
        Timestamp(System.currentTimeMillis()),
        "",
        "",
        "",
        mutableListOf(),
        mutableListOf()
        )

    val controller = StylusViewController(
        note,
        stylusPrefManager,
        pathEditor
    )

}