package de.prowebdev.wissensduell

import de.prowebdev.wissensduell.interfaces.GameDAO
import de.prowebdev.wissensduell.interfaces.StudentDAO
import de.prowebdev.wissensduell.interfaces.TeacherDAO
import de.prowebdev.wissensduell.plugins.configureHTTP
import de.prowebdev.wissensduell.plugins.configureMonitoring
import de.prowebdev.wissensduell.plugins.configureRouting
import de.prowebdev.wissensduell.plugins.configureSerialization
import de.prowebdev.wissensduell.storage.InMemoryGameDAO
import de.prowebdev.wissensduell.storage.InMemoryStudentDAO
import de.prowebdev.wissensduell.storage.InMemoryTeacherDAO
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

//fun main(args: Array<String>): Unit =
//  io.ktor.server.netty.EngineMain.main(args)

fun main() {

    io.ktor.server.netty.EngineMain.main(emptyArray())

}


@Suppress("unused") // Referenced in application.conf
fun Application.module() {
    configureHTTP()
    configureMonitoring()
    configureSerialization()
    configureRouting()

// Initialize DAOs
    val gameDAO: GameDAO = InMemoryGameDAO()
    val teacherDAO: TeacherDAO = InMemoryTeacherDAO()
    val studentDAO: StudentDAO = InMemoryStudentDAO()

    routing {
        post("/teacher") {
            val name = call.receive<String>()
            val teacher = teacherDAO.createTeacher(name)
            call.respond(HttpStatusCode.Created, teacher)
        }
        post("/student") {
            val name = call.receive<String>()
            val gameId = call.parameters["gameId"]?.toIntOrNull()
            if (gameId != null) {
                val student = studentDAO.createStudent(name, gameId)
                call.respond(HttpStatusCode.Created, student)
            } else {
                call.respond(HttpStatusCode.BadRequest, "Missing or invalid gameId parameter")
            }
        }
        post("/game") {
            val teacherId = call.parameters["teacherId"]?.toIntOrNull()
            if (teacherId != null) {
                val game = gameDAO.createGame(teacherId)
                call.respond(HttpStatusCode.Created, game)
            } else {
                call.respond(HttpStatusCode.BadRequest, "Missing or invalid teacherId parameter")
            }
        }
        post("/game/{gameId}/join") {
            val gameId = call.parameters["gameId"]?.toIntOrNull()
            val studentId = call.parameters["studentId"]?.toIntOrNull()

            if (gameId != null && studentId != null) {
                // Implement game joining logic
                call.respond(HttpStatusCode.OK, "Student $studentId has joined game $gameId")
            } else {
                call.respond(HttpStatusCode.BadRequest, "Missing or invalid gameId or studentId parameter")
            }
        }
        post("/game/{gameId}/start") {
            val gameId = call.parameters["gameId"]?.toIntOrNull()
            val teacherId = call.parameters["teacherId"]?.toIntOrNull()

            if (gameId != null && teacherId != null) {
                // Implement game starting logic
                call.respond(HttpStatusCode.OK, "Game $gameId started by teacher $teacherId")
            } else {
                call.respond(HttpStatusCode.BadRequest, "Missing or invalid gameId or teacherId parameter")
            }
        }
        post("/game/{gameId}/next") {
            val gameId = call.parameters["gameId"]?.toIntOrNull()
            val teacherId = call.parameters["teacherId"]?.toIntOrNull()

            if (gameId != null && teacherId != null) {
                // Implement showing next question logic
                call.respond(HttpStatusCode.OK, "Next question for game $gameId by teacher $teacherId")
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
    }
}