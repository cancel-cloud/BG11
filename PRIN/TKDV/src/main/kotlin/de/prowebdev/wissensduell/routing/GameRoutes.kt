package de.prowebdev.wissensduell.routing

import com.fasterxml.jackson.databind.ObjectMapper
import de.prowebdev.wissensduell.storage.YamlGameDAO
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.configureGameRoutes() {
    post("/game") {
        val teacherId = call.parameters["teacherId"]?.toIntOrNull()
        if (teacherId != null) {
            val game = gameDAO.createGame(teacherId)
            call.respond(HttpStatusCode.Created, game)
        } else {
            call.respond(HttpStatusCode.BadRequest, "Missing or invalid teacherId parameter")
        }
    }
    get("/games") {
        val games = gameDAO.getTotalGames()
        call.respond(HttpStatusCode.OK, games)
    }

    get("/start") {
        val gameId = call.parameters["gameId"]?.toIntOrNull()
        val caller = call.parameters["teacherId"]?.toIntOrNull()
        if (gameId != null && caller != null) {
            val game = gameDAO.getGameById(gameId)
            if (game != null && game.teacherId == caller) {

                call.respond(HttpStatusCode.OK, "Game with id $gameId started")
            } else {
                call.respond(HttpStatusCode.NotFound, "Game with id $gameId not found")
            }
        }
    }
    post("/game/{gameId}/join") {
        val gameId = call.parameters["gameId"]?.toIntOrNull()
        val studentId = call.parameters["studentId"]?.toIntOrNull()

        if (gameId != null && studentId != null) {
            // Implement game joining logic
            gameDAO.addStudent(gameId, studentDAO.getStudentById(studentId)!!)
            call.respond(HttpStatusCode.OK, "Student $studentId has joined game $gameId")
        } else {
            call.respond(HttpStatusCode.BadRequest, "Missing or invalid gameId or studentId parameter")
        }
    }
    post("/game/question/next") {
        val gameId = call.parameters["gameId"]?.toIntOrNull()
        val callId = call.parameters["callId"]?.toIntOrNull()

        if (gameId != null && callId != null) {
            // Implement game starting logic
            if (gameDAO.getGameById(gameId)!!.teacherId != callId) {
                call.respondRedirect("/questions/${gameDAO.getGameById(gameId)!!.lastQuestion + 1}")
                return@post
            }
        } else {
            call.respond(HttpStatusCode.BadRequest, "Missing or invalid gameId or callId parameter.")
        }
    }
    post("/game/question") {
        val gameId = call.parameters["gameId"]?.toIntOrNull()
        val teacherId = call.parameters["teacherId"]?.toIntOrNull()

        if (gameId != null && teacherId != null) {
            // Implement showing next question logic
            println("Next question for game $gameId by teacher $teacherId")
            call.respond(HttpStatusCode.OK, YamlGameDAO().getGameById(gameId)!!.currentQuestion)
        } else {
            call.respond(HttpStatusCode.BadRequest, "Missing or invalid gameId or teacherId parameter")
        }
    }
    post("/game/{gameId}/answer") {
        val gameId = call.parameters["gameId"]?.toIntOrNull()
        val studentId = call.parameters["studentId"]?.toIntOrNull()
        val answer = call.receive<Int>()
        if (gameId != null && studentId != null) {
            // Implement answer submission logic
            call.respond(HttpStatusCode.OK, "Student $studentId submitted answer $answer for game $gameId")
        } else {
            call.respond(HttpStatusCode.BadRequest, "Missing or invalid gameId or studentId parameter")
        }
    }
    get("/game/{gameId}/results") {
        val gameId = call.parameters["gameId"]?.toIntOrNull()

        if (gameId != null) {
            val game = gameDAO.getGameById(gameId)
            if (game != null) {
                // Implement retrieving game results logic
                call.respond(HttpStatusCode.OK, game.results)
            } else {
                call.respond(HttpStatusCode.NotFound, "Game not found")
            }
        } else {
            call.respond(HttpStatusCode.BadRequest, "Missing or invalid gameId parameter")
        }
    }

    get("/game/info") {
        val gameId = call.parameters["gameId"]?.toIntOrNull() ?: 1
        if (gameId != null) {
            val game = gameDAO.getGameById(gameId)
            val gameJson = ObjectMapper().writeValueAsString(game)

            call.respond(HttpStatusCode.OK, gameJson)
        } else {
            call.respond(HttpStatusCode.BadGateway, "Something is wrong")
        }
    }

    post("/startnow") {
        val gameId = call.parameters["gameId"]?.toIntOrNull()
        val teacherId = call.parameters["teacherId"]?.toIntOrNull()
        if ((gameId != null) && (teacherId != null)) {
            val game = gameDAO.getGameById(gameId)
            if (game != null && game.teacherId == teacherId) {
                gameDAO.setstarted(true)
                call.respond(HttpStatusCode.OK, "Game with id $gameId started")
            } else {
                call.respond(HttpStatusCode.NotFound, "Game with id $gameId not found")
            }
        }
    }

    get("/hasstarted") {
        call.respondText(YamlGameDAO().getstarted().toString())
    }
}