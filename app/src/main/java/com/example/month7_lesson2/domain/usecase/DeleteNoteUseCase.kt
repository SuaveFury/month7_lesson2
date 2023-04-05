package com.example.month7_lesson2.domain.usecase

import com.example.month7_lesson2.domain.model.NOte
import com.example.month7_lesson2.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
    fun deleteNOte(nOte: NOte) = noteRepository.deleteNote(nOte)
}