package com.example.month7_lesson2.data.repository

import com.example.month7_lesson2.data.base.BaseRepository
import com.example.month7_lesson2.data.mapper.toEntity
import com.example.month7_lesson2.data.mapper.toNOte
import com.example.month7_lesson2.data.model.NoteDao
import com.example.month7_lesson2.domain.model.NOte
import com.example.month7_lesson2.domain.repository.NoteRepository
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDAo: NoteDao
) : NoteRepository,
    BaseRepository() {
    override fun createNote(nOte: NOte) = doRequest {
        noteDAo.createNote(nOte.toEntity())
    }
    override fun getAllNotes() = doRequest {
        noteDAo.getAllNotes().map {
            it.toNOte() }
    }
    override fun editNote(nOte: NOte) = doRequest {
        noteDAo.editNotes(nOte.toEntity())
    }
    override fun deleteNote(nOte: NOte) = doRequest {
        noteDAo.deleteNOte(nOte.toEntity())}
}