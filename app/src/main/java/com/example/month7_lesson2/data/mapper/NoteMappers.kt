package com.example.month7_lesson2.data.mapper

import com.example.month7_lesson2.data.model.NoteEntity
import com.example.month7_lesson2.domain.model.NOte

fun NOte.toEntity() = NoteEntity(
    id, title, desc
)
fun NoteEntity.toNOte() = NOte(
    id, title, desc
)