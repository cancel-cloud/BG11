package de.prowebdev.wissensduell.models

import kotlinx.serialization.Serializable

@Serializable
enum class GameState {
    NOT_STARTED,
    ONGOING,
    FINISHED
}