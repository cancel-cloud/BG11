package de.prowebdev.wissensduell.models

import kotlinx.serialization.Serializable

@Serializable
data class Question(
    val question: String,
    val answers: List<String>,
    val correctAnswer: Int
)