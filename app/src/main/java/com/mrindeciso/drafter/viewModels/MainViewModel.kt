package com.mrindeciso.drafter.viewModels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrindeciso.util.db.DefaultContent
import com.mrindeciso.util.repo.BrushRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val brushRepository: BrushRepo
) : ViewModel() {

    fun setupDB() = viewModelScope.launch(Dispatchers.IO) {
        if (brushRepository.brushCount() <= 0) {
            brushRepository.insertBrush(*DefaultContent.defaultBrushes.toTypedArray())
        }
    }

}