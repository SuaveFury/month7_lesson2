package com.example.month7_lesson2.domain.usecase

import com.example.month7_lesson2.domain.model.NOte
import com.example.month7_lesson2.domain.repository.NoteRepository
import javax.inject.Inject

class EditNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
    fun editNOte(note: NOte) = noteRepository.editNote(note)
}