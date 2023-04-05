package com.example.month7_lesson2.domain.usecase

import com.example.month7_lesson2.domain.repository.NoteRepository
import javax.inject.Inject

class GetAllNotesUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
    fun getaAllNotes() = noteRepository.getAllNotes()
}