package cloud.coffeesystems.big

import java.util.*
fun main() {
    while (true) {
        val scanner = Scanner(System.`in`)
        println("Geben Sie die Größe des USB-Sticks in GB ein:")
        val stickSize = scanner.nextInt()
        println("Geben sie die lesegeschwindigkeit des USB-Sticks in MB/s ein:")
        val stickSpeed = scanner.nextInt()
        val calsec = stickSize * 1024 / stickSpeed
        val calmin = calsec / 60
        val calhour = calmin / 60
        val calday = String.format("%.2f", (calhour / 24).toDouble())

        println("Der Stick braucht:\n$calday Tage\n$calhour Stunden\n$calmin Minuten\n$calsec Sekunden\num $stickSize GB zu lesen")
        println("---------------------------------")
    }
}