package com.example.sixthlecture

import java.util.*

class Person {
//    data class PersonID(val id: String, val data: PersonData)

    data class PersonData(
        val id: String,
        val FIO: String,
        val status: Boolean,
        val BD: String,
        val avatar: String?,
        val experience: String,
        val phone: String,
        val email: String,
        val vk: String?,
        val department: String,
        val position: String,
        val projects: String?,
        val achievements: String?,
        val awards: String?,
        )
}