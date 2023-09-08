package de.prowebdev.wissensduell.routing

import de.prowebdev.wissensduell.storage.YamlTeacherDAO
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.configureTeacherRoutes() {
    post("/teacher") {
        val name = call.receive<String>()
        val teacher = teacherDAO.createTeacher(name)
        call.respond(HttpStatusCode.Created, teacher)
    }
    get("/teachers") {
        val teachers = (teacherDAO as YamlTeacherDAO).teachers
        call.respond(HttpStatusCode.OK, teachers)
    }

    get("/teacher") {
        val teacherId = call.parameters["teacherId"]?.toIntOrNull()
        val teacherName = call.parameters["teacherName"]
        if (teacherId != null) {
            val teacher = teacherDAO.getTeacherById(teacherId)
            if (teacher != null && teacher.name == teacherName) {
                call.respond(HttpStatusCode.OK, "Teacher with id $teacherId and name $teacherName found")
            } else {
                call.respond(HttpStatusCode.NotFound, "Teacher with id $teacherId not found")
            }
        }
    }
}
