package de.prowebdev.wissensduell.interfaces

import de.prowebdev.wissensduell.models.GamestateModel

interface GameDAO {
    fun createGame(teacherId: Int): GamestateModel
    fun getGameById(gameId: Int): GamestateModel?
    fun updateGame(game: GamestateModel)
    fun getTotalGames(): Int
}