package com.example.month7_lesson2.presentation.ui

import androidx.lifecycle.MutableLiveData
import com.example.month7_lesson2.domain.model.Note
import com.example.month7_lesson2.domain.usecase.DeleteNoteUseCase
import com.example.month7_lesson2.domain.usecase.GetAllNotesUseCase
import com.example.month7_lesson2.presentation.ui.base.BaseViewModel
import com.example.month7_lesson2.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class NotesViewModel  @Inject constructor(
    private val getAllNOteUseCase:GetAllNotesUseCase,
    private val deleteAllNotesUseCase: DeleteNoteUseCase
): BaseViewModel() {

    private val _getAllNOtesState = MutableStateFlow<UIState<List<Note>>>(UIState.Empty())
    val getAllNOtesState =_getAllNOtesState.asStateFlow()

    private val _deleteNote = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val deleteNoteState =_deleteNote.asStateFlow()

    val loading = MutableLiveData<Boolean>()

    fun getAllNOtes(){
        getAllNOteUseCase.getaAllNotes().collectData(_getAllNOtesState)
    }
    fun deleteNote(nOte: Note){
        deleteAllNotesUseCase.deleteNOte(nOte).collectData(_deleteNote)
    }
}