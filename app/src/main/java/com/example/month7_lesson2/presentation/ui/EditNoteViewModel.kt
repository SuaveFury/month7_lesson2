package com.example.month7_lesson2.presentation.ui

import androidx.lifecycle.MutableLiveData
import com.example.month7_lesson2.domain.model.Note
import com.example.month7_lesson2.domain.usecase.CreateNoteUseCase
import com.example.month7_lesson2.domain.usecase.EditNoteUseCase
import com.example.month7_lesson2.presentation.ui.base.BaseViewModel
import com.example.month7_lesson2.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class EditNoteViewModel @Inject constructor(
    private val createNoteUseCase: CreateNoteUseCase,
    private val editNoteUseCase: EditNoteUseCase,
): BaseViewModel() {
    private val _createNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val createNoteState = _createNoteState.asStateFlow()
    private val _editNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val editNoteState = _editNoteState.asStateFlow()

    val loading = MutableLiveData<Boolean>()

    fun addNote(note: Note) {
        createNoteUseCase.createNOte(note).collectData(_createNoteState)
    }
    fun editNote(note: Note){
        editNoteUseCase.editNOte(note).collectData(_editNoteState)
    }
}