package de.prowebdev.wissensduell.routing

import de.prowebdev.wissensduell.interfaces.StudentDAO
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.configureStudentRoutes() {
    post("/student") {
        val name = call.parameters["name"] ?: "lenin"
        val gameId = call.parameters["gameId"]?.toIntOrNull()
        var profilePicture = call.parameters["profilePicture"] ?: ""
        if (profilePicture.isEmpty() || profilePicture.isBlank()) {
            profilePicture =
                "https://post.healthline.com/wp-content/uploads/2019/04/Weed_Orange_1296x728-header-1296x728.jpg"
        }
        if (gameId != null) {
            val student = studentDAO.createStudent(name, gameId, profilePicture)
            gameDAO.addStudent(gameId, studentDAO.getStudentById(student.studentId)!!)
            call.respond(HttpStatusCode.Created, student)

        } else {
            call.respond(HttpStatusCode.BadRequest, "Missing or invalid gameId parameter")
        }
    }
    get("/students") {
        val students = (studentDAO as StudentDAO).getTotalStudents()
        call.respond(HttpStatusCode.OK, students)
    }

    post("/update") {
        val gameId = call.parameters["gameId"]?.toIntOrNull()
        val studentName = call.parameters["username"] ?: "lenin"
        val points = call.parameters["points"]?.toIntOrNull()

        if (gameId != null && studentName != "lenin" && points != null) {
            val student = studentDAO.updatePoints(gameId, studentName, points)
            call.respond(HttpStatusCode.OK, studentDAO.getStudentbyName(studentName)!!.points)
        } else {
            call.respond(HttpStatusCode.BadRequest, "Missing or invalid gameId, studentId or points parameter")
        }
    }
}
