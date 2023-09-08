package de.prowebdev.wissensduell

import de.prowebdev.wissensduell.plugins.configureHTTP
import de.prowebdev.wissensduell.plugins.configureMonitoring
import de.prowebdev.wissensduell.plugins.configureSerialization
import de.prowebdev.wissensduell.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args = args)
}


@Suppress("unused") // Referenced in application.conf
fun Application.module() {
    var counter = 0
    configureHTTP()
    configureMonitoring()
    configureSerialization()
    routing {
        configureStatsRoutes()
        configureQuestionRoutes()
        configureTeacherRoutes()
        configureStudentRoutes()
        configureGameRoutes()
        configureShutdownRoutes()
        get("/") {
            call.respondText("Du hast das schon $counter aufgerufen.")
            counter++
        }
    }
}