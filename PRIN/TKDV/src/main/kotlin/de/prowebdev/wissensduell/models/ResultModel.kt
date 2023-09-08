package de.prowebdev.wissensduell.models

import kotlinx.serialization.Serializable

@Serializable
data class ResultModel(
    val answer: Int,
    val points: Int
)