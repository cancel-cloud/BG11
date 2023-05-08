package de.prowebdev.wissensduell.plugins

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import de.prowebdev.wissensduell.interfaces.GameDAO
import de.prowebdev.wissensduell.interfaces.StudentDAO
import de.prowebdev.wissensduell.interfaces.TeacherDAO
import de.prowebdev.wissensduell.storage.InMemoryGameDAO
import de.prowebdev.wissensduell.storage.InMemoryStudentDAO
import de.prowebdev.wissensduell.storage.InMemoryTeacherDAO
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    val mapper = YAMLMapper()

    val gameDAO: GameDAO = InMemoryGameDAO()
    val teacherDAO: TeacherDAO = InMemoryTeacherDAO()
    val studentDAO: StudentDAO = InMemoryStudentDAO()

    routing {

        get("/stats") {
            call.respond(
                mapOf(
                    "totalGames" to gameDAO.getTotalGames(),
                    "totalTeachers" to teacherDAO.getTotalTeachers(),
                    "totalStudents" to studentDAO.getTotalStudents()
                )
            )
        }
        static("/") {
            resources("")
            defaultResource("index.html")
        }

        get("/questions") {
            val inputStream = this::class.java.classLoader.getResourceAsStream("questions.yaml")

            val data: Map<*, *>? = mapper.readValue(inputStream, Map::class.java)
            call.respondText(data.toString(), ContentType.Text.Plain)
        }
    }
}
