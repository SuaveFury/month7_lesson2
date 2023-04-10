package com.example.month7_lesson2.presentation.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.month7_lesson2.domain.model.NOte
import com.example.month7_lesson2.domain.usecase.DeleteNoteUseCase
import com.example.month7_lesson2.domain.usecase.GetAllNotesUseCase
import com.example.month7_lesson2.domain.utils.Resource
import com.example.month7_lesson2.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NotesViewModel  @Inject constructor(
    private val getAllNOteUseCase: GetAllNotesUseCase,
    private val deleteAllNotesUseCase: DeleteNoteUseCase
): ViewModel() {
    private val _getAllNOtesState = MutableStateFlow<UIState<List<NOte>>>(UIState.Empty())
    val getAllNOtesState =_getAllNOtesState.asStateFlow()
    private val _deleteNote = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val deleteNoteState =_deleteNote
    val loading = MutableLiveData<Boolean>()
    fun getAllNOtes(){
        viewModelScope.launch {
            getAllNOteUseCase.getaAllNotes().collect{
                when(it){
                    is Resource.Error -> {
                        _getAllNOtesState.value= UIState.Error(it.message!!)
                    }
                    is Resource.Loading -> {
                        _getAllNOtesState.value=UIState.Loading()
                    }
                    is Resource.Success -> {
                        if (it.data!=null){
                            _getAllNOtesState.value= UIState.Success(it.data)
                        }
                    }
                }
            }
        }
    }
    fun deleteNote(nOte: NOte){
        viewModelScope.launch {
            deleteAllNotesUseCase.deleteNOte(nOte).collect{
                when(it){
                    is Resource.Error -> {
                        _deleteNote.value=UIState.Error(it.message.toString())
                    }
                    is Resource.Loading -> {
                        _deleteNote.value=UIState.Loading()
                    }
                    is Resource.Success -> {
                        if (it.data!=null){
                            _deleteNote.value=UIState.Success(it.data)
                        }
                    }
                }
            }
        }
    }
}