package de.prowebdev.wissensduell.routing

import de.prowebdev.wissensduell.storage.saveDataToFile
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlin.system.exitProcess

fun Route.configureShutdownRoutes() {
    post("/shutdown") {
        val shutdownPhrase = call.parameters["secret"] ?: "ICH HABE DICH NICHT"
        val secretPhrase = "your-secret-phrase"

        if (shutdownPhrase == secretPhrase) {
            // Save memory stats to a file
            saveDataToFile(gameDAO, teacherDAO, studentDAO)

            // Shutdown the server gracefully
            call.respond(HttpStatusCode.OK, "Server shutting down...")
            exitProcess(0)
        } else {
            call.respond(HttpStatusCode.Forbidden, "Invalid shutdown phrase")
        }
    }
}
