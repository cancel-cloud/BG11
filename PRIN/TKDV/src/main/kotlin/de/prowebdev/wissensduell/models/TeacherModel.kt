package de.prowebdev.wissensduell.models

import kotlinx.serialization.Serializable

@Serializable
data class TeacherModel(
    val teacherId: Int,
    val name: String
)
