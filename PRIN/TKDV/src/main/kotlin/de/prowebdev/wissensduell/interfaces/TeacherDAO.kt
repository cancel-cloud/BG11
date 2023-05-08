package de.prowebdev.wissensduell.interfaces

import de.prowebdev.wissensduell.models.TeacherModel

interface TeacherDAO {
    fun createTeacher(name: String): TeacherModel
    fun getTeacherById(teacherId: Int): TeacherModel?
    fun getTotalTeachers(): Int
}