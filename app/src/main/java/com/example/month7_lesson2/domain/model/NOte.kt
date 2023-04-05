package com.example.month7_lesson2.domain.model

class NOte(
    val id: Int = DEFAULT_ID,
    val title: String,
    val desc: Int
) {
    companion object {
        const val DEFAULT_ID = 0
    }
}
