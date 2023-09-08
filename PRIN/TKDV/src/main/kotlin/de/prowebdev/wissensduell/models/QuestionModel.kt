package de.prowebdev.wissensduell.models

import kotlinx.serialization.Serializable

@Serializable
data class QuestionModel(
    val questionId: Int,
    val questionText: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)