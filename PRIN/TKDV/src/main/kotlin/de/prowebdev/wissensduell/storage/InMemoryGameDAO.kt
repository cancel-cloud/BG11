package de.prowebdev.wissensduell.storage

import de.prowebdev.wissensduell.interfaces.GameDAO
import de.prowebdev.wissensduell.interfaces.StudentDAO
import de.prowebdev.wissensduell.interfaces.TeacherDAO
import de.prowebdev.wissensduell.models.*

class InMemoryGameDAO : GameDAO {
    private val games = mutableListOf<GamestateModel>()

    override fun createGame(teacherId: Int): GamestateModel {
        val game = GamestateModel(
            games.size + 1,
            teacherId,
            GameState.NOT_STARTED,
            QuestionModel(0, "", emptyList(), -1),
            emptyList(),
            emptyMap()
        )
        games.add(game)
        return game
    }

    override fun getGameById(gameId: Int): GamestateModel? {
        return games.find { it.gameId == gameId }
    }

    override fun updateGame(game: GamestateModel) {
        val index = games.indexOfFirst { it.gameId == game.gameId }
        if (index != -1) {
            games[index] = game
        }
    }

    override fun getTotalGames(): Int = games.size

}

class InMemoryTeacherDAO : TeacherDAO {
    private val teachers = mutableListOf<TeacherModel>()

    override fun createTeacher(name: String): TeacherModel {
        val teacher = TeacherModel(teachers.size + 1, name)
        teachers.add(teacher)
        return teacher
    }

    override fun getTeacherById(teacherId: Int): TeacherModel? {
        return teachers.find { it.teacherId == teacherId }
    }

    override fun getTotalTeachers(): Int = teachers.size
}

class InMemoryStudentDAO : StudentDAO {
    private val students = mutableListOf<StudentModel>()

    override fun createStudent(name: String, gameId: Int): StudentModel {
        val student = StudentModel(students.size + 1, name, gameId)
        students.add(student)
        return student
    }

    override fun getStudentById(studentId: Int): StudentModel? {
        return students.find { it.studentId == studentId }
    }

    override fun getStudentsByGameId(gameId: Int): List<StudentModel> {
        return students.filter { it.gameId == gameId }
    }

    override fun getTotalStudents(): Int = students.size
}
