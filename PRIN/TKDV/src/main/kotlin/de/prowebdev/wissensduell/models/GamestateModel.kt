package de.prowebdev.wissensduell.models

data class GamestateModel(
    val gameId: Int,
    val teacherId: Int,
    var gameState: GameState,
    var currentQuestion: QuestionModel,
    val questions: List<QuestionModel>,
    var results: Map<Int, Int> // StudentId to score
)
