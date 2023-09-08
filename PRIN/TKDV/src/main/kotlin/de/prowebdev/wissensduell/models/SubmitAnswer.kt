package de.prowebdev.wissensduell.models

import kotlinx.serialization.Serializable

@Serializable
data class SubmitAnswer(
    val gameId: Int,
    val studentId: Int,
    val answer: Int
)