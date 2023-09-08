package de.prowebdev.wissensduell.models

import kotlinx.serialization.Serializable

@Serializable
data class GamestateModel(
    val gameId: Int,
    val teacherId: Int,
    var students: List<StudentModel>,
    //var gameState: GameState,
    var currentQuestion: QuestionModel,
    var lastQuestion: Int,
    var results: MutableMap<Int, ResultModel>
)