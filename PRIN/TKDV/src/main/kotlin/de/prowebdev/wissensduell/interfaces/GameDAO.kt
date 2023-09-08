package de.prowebdev.wissensduell.interfaces

import de.prowebdev.wissensduell.models.GamestateModel
import de.prowebdev.wissensduell.models.StudentModel

interface GameDAO {
    fun createGame(teacherId: Int): GamestateModel
    fun getGameById(gameId: Int): GamestateModel?
    fun addStudent(gameId: Int, student: StudentModel)
    fun getTotalGames(): Int

    fun getCorrectAnswer(questionId: Int): Int?
    fun saveGame()
    fun getstarted(): Boolean
    fun setstarted(started: Boolean)
}