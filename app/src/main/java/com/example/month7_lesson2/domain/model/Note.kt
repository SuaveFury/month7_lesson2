package com.example.month7_lesson2.domain.model

class Note(
    var id: Int? =null,
    var title: String?=null,
    var desc: String?=null
):java.io.Serializable{
    companion object {
        const val DEFAULT_ID = 0
    }
}
