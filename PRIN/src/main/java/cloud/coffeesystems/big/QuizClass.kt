package cloud.coffeesystems.big


fun main() {
    val quiz = QuizClass()
    quiz.quiz()
}

data class SingleQuestion(
    val question: String = "",
    val answerone: String = "",
    val answertwo: String = "",
    val answerthree: String = "",
    val answerfour: String = "",
    val correctAnswer: String = ""
)

data class Questions(
    val questionsList: List<SingleQuestion>
)


class QuizClass {

    private val singleQuestion1 = SingleQuestion("What is the capital of France?", "Paris", "Madrid", "Rome", "Berlin", "Paris")
    private val singleQuestion2 = SingleQuestion("What is the largest planet in our solar system?", "Jupiter", "Saturn", "Neptune", "Uranus", "Jupiter")
    private val singleQuestion3 = SingleQuestion("What is the smallest country in the world?", "Vatican City", "Monaco", "Nauru", "Tuvalu", "Vatican City")

    private val questionsList = listOf(singleQuestion1, singleQuestion2, singleQuestion3)

    fun quiz() {
        val questions = Questions(questionsList)
        println(questions.questionsList.forEach {
            println("----------------")
            println(it.question)
            println(it.answerone)
            println(it.answertwo)
            println(it.answerthree)
            println(it.answerfour)
            println("----------------")
        })
    }
}