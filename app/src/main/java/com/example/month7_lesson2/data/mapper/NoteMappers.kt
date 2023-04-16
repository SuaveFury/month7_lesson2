package com.example.month7_lesson2.data.mapper

import com.example.month7_lesson2.data.model.NoteEntity
import com.example.month7_lesson2.domain.model.Note

fun Note.toEntity() = NoteEntity(
    id, title, desc
)
fun NoteEntity.toNOte() = Note(
    id, title, desc
)