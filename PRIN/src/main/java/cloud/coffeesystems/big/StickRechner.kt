package cloud.coffeesystems.big

import java.util.*


data class Stick(
    val name: String,
    val size: Int,
    val speed: Double
)

fun main() {
    println("USB-Stick-Rechner")
    println("Geben Sie die Größe des USB-Sticks in GB ein:")
    val stickSize = readln().toInt()
    println("Geben sie die lesegeschwindigkeit des USB-Sticks in MB/s ein:")
    val stickSpeed = readln().toDouble()
    val calsec = stickSize * 1024 / stickSpeed
    val stick = Stick("USB-Stick", stickSize, stickSpeed)

    while (true) {
        println("Was möchten sie tun?")
        println("1. Zeit berechnen, für den Stick komplett zu beschreiben")
        println("2. Zeit berechnen, wie lange eine X GB Datei benötigt, um auf den Stick geschreiben zu werden.")
        println("3. Beenden")

        val scanner = Scanner(System.`in`)
        val input = scanner.nextInt()
        when (input) {
            1 -> writeFullStick(stick)
            2 -> writeXGBtoStick(stick)
            3 -> System.exit(0)
            else -> println("Falsche Eingabe")
        }
    }
}

fun writeFullStick(stick: Stick) {
    val calsec = stick.size * 1024 / stick.speed
    val calmin = calsec / 60
    val calhour = calmin / 60
    val calday = String.format("%.2f", (calhour / 24))

    println(buildString {
        append("Der Stick braucht:\n")
        append(calday)
        append(" Tage\n")
        append(calhour)
        append(" Stunden\n")
        append(calmin)
        append(" Minuten\n")
        append(calsec)
        append(" Sekunden\num ")
        append(stick.size)
        append(" GB zu schreiben")
    })
    println("---------------------------------")
}

fun writeXGBtoStick(stick: Stick) {
    val scanner = Scanner(System.`in`)
    println("Geben Sie die Größe der Datei in GB ein:")
    val x = scanner.nextInt()
    val calsec = x * 1024 / stick.speed
    val calmin = calsec / 60
    val calhour = calmin / 60
    val calday = String.format("%.2f", (calhour / 24).toDouble())
    println(buildString {
        append("Der Stick braucht:\n")
        append(calday)
        append(" Tage\n")
        append(calhour)
        append(" Stunden\n")
        append(calmin)
        append(" Minuten\n")
        append(calsec)
        append(" Sekunden\num ")
        append(x)
        append(" GB zu schreiben")
    })
    println("---------------------------------")
}