package de.prowebdev.wissensduell.interfaces

import de.prowebdev.wissensduell.models.StudentModel

interface StudentDAO {
    fun createStudent(name: String, gameId: Int): StudentModel
    fun getStudentById(studentId: Int): StudentModel?
    fun getStudentsByGameId(gameId: Int): List<StudentModel>
    fun getTotalStudents(): Int
}