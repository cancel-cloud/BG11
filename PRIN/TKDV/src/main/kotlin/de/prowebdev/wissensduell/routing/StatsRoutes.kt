package de.prowebdev.wissensduell.routing

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.configureStatsRoutes() {
    get("/stats") {
        call.respond(
            mapOf(
                "totalGames" to gameDAO.getTotalGames(),
                "totalTeachers" to teacherDAO.getTotalTeachers(),
                "totalStudents" to studentDAO.getTotalStudents()
            )
        )
    }
}