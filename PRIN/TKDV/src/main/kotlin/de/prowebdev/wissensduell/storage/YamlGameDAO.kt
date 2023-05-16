package de.prowebdev.wissensduell.storage

import de.prowebdev.wissensduell.interfaces.GameDAO
import de.prowebdev.wissensduell.interfaces.StudentDAO
import de.prowebdev.wissensduell.interfaces.TeacherDAO
import de.prowebdev.wissensduell.models.*
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import net.mamoe.yamlkt.Yaml
import java.io.File

@Serializable
class YamlGameDAO(val games: MutableList<GamestateModel> = mutableListOf()) : GameDAO {
    @Contextual
    private val gameFile = File("games.yaml")

    init {
        if (gameFile.exists()) {
            val data = gameFile.readText()
            try {
                games.addAll(Yaml.decodeFromString<List<GamestateModel>>(data))

            }catch (_: Exception) {
            }
        }
    }

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
        gameFile.writeText(Yaml.encodeToString(games))
        return game
    }

    override fun getGameById(gameId: Int): GamestateModel? {
        return games.find { it.gameId == gameId }
    }

    override fun updateGame(game: GamestateModel) {
        val index = games.indexOfFirst { it.gameId == game.gameId }
        if (index != -1) {
            games[index] = game
            gameFile.writeText(Yaml.encodeToString(games))
        }
    }

    override fun getTotalGames(): Int = games.size
}

@Serializable
class YamlTeacherDAO(val teachers: MutableList<TeacherModel> = mutableListOf()) : TeacherDAO {
    @Contextual
    private val teacherFile = File("teachers.yaml")

    init {
        if (teacherFile.exists()) {
            val data = teacherFile.readText()
            try {
                teachers.addAll(Yaml.decodeFromString<List<TeacherModel>>(data))

            } catch (_: Exception) {
            }
        }
    }

    override fun createTeacher(name: String): TeacherModel {
        val teacher = TeacherModel(teachers.size + 1, name)
        teachers.add(teacher)
        teacherFile.writeText(Yaml.encodeToString(teachers))
        return teacher
    }

    override fun getTeacherById(teacherId: Int): TeacherModel? {
        return teachers.find { it.teacherId == teacherId }
    }

    override fun getTotalTeachers(): Int = teachers.size
}

@Serializable
class YamlStudentDAO(val students: MutableList<StudentModel> = mutableListOf()) : StudentDAO {
    @Contextual
    private val studentFile = File("students.yaml")

    init {
        if (studentFile.exists()) {
            val data = studentFile.readText()
            try {
            students.addAll(Yaml.decodeFromString<List<StudentModel>>(data))
            } catch (_: Exception) {
            }
        }
    }

    override fun createStudent(name: String, gameId: Int): StudentModel {
        val student = StudentModel(students.size + 1, name, gameId)
        students.add(student)
        studentFile.writeText(Yaml.encodeToString(students))
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

fun saveDataToFile(gameDAO: GameDAO, teacherDAO: TeacherDAO, studentDAO: StudentDAO) {
    val gamesData = Yaml.encodeToString((gameDAO as YamlGameDAO).games)
    val teachersData = Yaml.encodeToString((teacherDAO as YamlTeacherDAO).teachers)
    val studentsData = Yaml.encodeToString((studentDAO as YamlStudentDAO).students)

    File("games.yaml").writeText(gamesData)
    File("teachers.yaml").writeText(teachersData)
    File("students.yaml").writeText(studentsData)
}