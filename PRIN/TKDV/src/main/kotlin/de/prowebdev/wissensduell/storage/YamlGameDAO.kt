package de.prowebdev.wissensduell.storage

import de.prowebdev.wissensduell.interfaces.GameDAO
import de.prowebdev.wissensduell.interfaces.StudentDAO
import de.prowebdev.wissensduell.interfaces.TeacherDAO
import de.prowebdev.wissensduell.models.*
import de.prowebdev.wissensduell.routing.gameDAO
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import net.mamoe.yamlkt.Yaml
import java.io.File
import kotlin.math.max


var playing = false

@Serializable
class YamlGameDAO(val games: MutableList<GamestateModel> = mutableListOf()) : GameDAO {
    @Contextual
    private val gameFile = File("games.yaml")

    @Contextual
    private val questionsFile = File("questions.yaml")
    private var questions: MutableList<Question> = mutableListOf()

    init {
        if (gameFile.exists()) {
            val data = gameFile.readText()
            try {
                games.addAll(Yaml.decodeFromString<List<GamestateModel>>(data))
            } catch (_: Exception) {
            }
        }

        if (questionsFile.exists()) {
            val data = questionsFile.readText()
            try {
                questions.addAll(Yaml.decodeFromString<List<Question>>(data))
            } catch (_: Exception) {
            }
        }
    }

    init {
        if (gameFile.exists()) {
            val data = gameFile.readText()
            try {
                games.addAll(Yaml.decodeFromString<List<GamestateModel>>(data))
            } catch (_: Exception) {
            }
        }
    }

    override fun getCorrectAnswer(questionId: Int): Int? {
        return if (questionId in questions.indices) {
            questions[questionId].correctAnswer
        } else {
            null
        }
    }

    override fun createGame(teacherId: Int): GamestateModel {
        val game = GamestateModel(
            gameId = games.size + 1,
            teacherId = teacherId,
            students = emptyList(),
            //gameState = GameState.NOT_STARTED,
            currentQuestion = QuestionModel(0, "", emptyList(), 0),
            lastQuestion = -1,
            results = mutableMapOf()
        )
        games.add(game)
        gameFile.writeText(Yaml.encodeToString(games))
        return game
    }

    override fun getGameById(gameId: Int): GamestateModel? {
        return games.find { it.gameId == gameId }
    }

    override fun addStudent(gameId: Int, student: StudentModel) {
        val game = getGameById(gameId)!!
        val students = game.students.toMutableList()
        students.add(student)
        game.students = students
    }

    override fun getTotalGames(): Int = games.size

    fun submitAnswer(gameId: Int, studentId: Int, answer: Int) {
        val game = getGameById(gameId) ?: return
        val totalStudents = game.students.size
        val submissions = game.results.size
        val points = max(1, totalStudents - submissions)

        // Check if answer is correct
        if (game.currentQuestion.correctAnswerIndex != answer) {
            return
        }

        game.results[studentId] = ResultModel(answer, points)
        gameFile.writeText(Yaml.encodeToString(games))
    }

    override fun saveGame() {
        gameFile.writeText(Yaml.encodeToString(games))
    }

    override fun getstarted(): Boolean {
        return playing
    }

    override fun setstarted(started: Boolean) {
        playing = started
    }
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

    override fun createStudent(name: String, gameId: Int, profilePicture: String): StudentModel {
        val student = StudentModel(students.size + 1, name, profilePicture, gameId)
        students.add(student)
        studentFile.writeText(Yaml.encodeToString(students))
        return student
    }

    override fun getStudentById(studentId: Int): StudentModel? {
        return students.find { it.studentId == studentId }
    }

    override fun getStudentbyName(name: String): StudentModel? {
        return students.find { it.name == name }
    }

    override fun getStudentsByGameId(gameId: Int): List<StudentModel> {
        return students.filter { it.gameId == gameId }
    }

    override fun getTotalStudents(): Int = students.size

    override fun updatePoints(gameId: Int, username: String, points: Int) {
        val student = getStudentbyName(username) ?: return
        student.points += points
        studentFile.writeText(Yaml.encodeToString(students))
        gameDAO.getGameById(gameId)?.let { game ->
            game.students = game.students.map {
                if (it.name == username) {
                    it.copy(points = points)
                } else {
                    it
                }
            }
            gameDAO.saveGame()
        }
    }
}

fun saveDataToFile(gameDAO: GameDAO, teacherDAO: TeacherDAO, studentDAO: StudentDAO) {
    val gamesData = Yaml.encodeToString((gameDAO as YamlGameDAO).games)
    val teachersData = Yaml.encodeToString((teacherDAO as YamlTeacherDAO).teachers)
    val studentsData = Yaml.encodeToString((studentDAO as YamlStudentDAO).students)

    File("games.yaml").writeText(gamesData)
    File("teachers.yaml").writeText(teachersData)
    File("students.yaml").writeText(studentsData)
}