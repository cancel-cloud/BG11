package de.prowebdev.wissensduell.models

import kotlinx.serialization.Serializable

@Serializable
data class StudentModel(
    val studentId: Int,
    val name: String,
    val gameId: Int
)
