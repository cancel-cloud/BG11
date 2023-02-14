plugins {
    kotlin("jvm") version "1.8.0"
    application
}

group = "cloud.coffeesystems"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {


}

kotlin {
    jvmToolchain(18)
}
