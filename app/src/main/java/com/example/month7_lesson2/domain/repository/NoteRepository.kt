package com.example.month7_lesson2.domain.repository

import com.example.month7_lesson2.domain.model.Note
import com.example.month7_lesson2.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun createNote(nOte: Note): Flow<Resource<Unit>>
    fun getAllNotes(): Flow<Resource<List<Note>>>
    fun editNote(nOte: Note): Flow<Resource<Unit>>
    fun deleteNote(nOte: Note): Flow<Resource<Unit>>
}