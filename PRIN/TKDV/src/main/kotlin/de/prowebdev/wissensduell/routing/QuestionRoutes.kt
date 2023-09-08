package de.prowebdev.wissensduell.routing

import de.prowebdev.wissensduell.models.Question
import de.prowebdev.wissensduell.models.SubmitAnswer
import de.prowebdev.wissensduell.storage.YamlGameDAO
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.decodeFromString
import net.mamoe.yamlkt.Yaml
import java.io.File

fun Route.configureQuestionRoutes() {


    val questionsFile = File("questions.yaml")
    val questions = if (questionsFile.exists()) Yaml.decodeFromString<List<Question>>(questionsFile.readText())
        .toMutableList() else mutableListOf()

    route("/questions") {
        get {
            call.respond(HttpStatusCode.OK, questions)
        }

        get("/{id}") {
            val id = call.parameters["id"]?.toIntOrNull()
            if (id == null || id < 0 || id >= questions.size) {
                call.respond(HttpStatusCode.NotFound, "Question not found for id $id.")
            } else {
                call.respond(HttpStatusCode.OK, questions[id])
            }
        }
    }

    route("/answers") {
        get("/{id}") {
            val id = call.parameters["id"]?.toIntOrNull()
            val gameDAO = YamlGameDAO() // Use your actual dependency injection mechanism
            val correctAnswer = gameDAO.getCorrectAnswer(id!!)
            if (correctAnswer == null) {
                call.respond(HttpStatusCode.NotFound)
            } else {
                call.respond(HttpStatusCode.OK, correctAnswer)
            }
        }
    }

    route("/current") {
        get("/{gameId}") {
            val gameId = call.parameters["gameId"]?.toIntOrNull()
            val currentQuestion = gameDAO.getGameById(gameId!!)!!.currentQuestion
            call.respond(HttpStatusCode.OK, currentQuestion)
        }
    }

    route("/submitAnswer") {
        post {
            val submittedAnswer = call.receive<SubmitAnswer>()
            val gameDAO = YamlGameDAO() // Use your actual dependency injection mechanism
            gameDAO.submitAnswer(submittedAnswer.gameId, submittedAnswer.studentId, submittedAnswer.answer)
            call.respond(HttpStatusCode.OK)
        }
    }
}
