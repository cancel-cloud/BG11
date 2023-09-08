package de.prowebdev.wissensduell.routing

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import de.prowebdev.wissensduell.interfaces.GameDAO
import de.prowebdev.wissensduell.interfaces.StudentDAO
import de.prowebdev.wissensduell.interfaces.TeacherDAO
import de.prowebdev.wissensduell.storage.YamlGameDAO
import de.prowebdev.wissensduell.storage.YamlStudentDAO
import de.prowebdev.wissensduell.storage.YamlTeacherDAO

val mapper = YAMLMapper()

val gameDAO: GameDAO = YamlGameDAO()
val teacherDAO: TeacherDAO = YamlTeacherDAO()
val studentDAO: StudentDAO = YamlStudentDAO()
