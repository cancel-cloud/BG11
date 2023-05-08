package de.prowebdev.wissensduell.models

data class QuestionModel(
    val questionId: Int,
    val questionText: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)