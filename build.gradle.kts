plugins {
    kotlin("jvm") version "2.0.0"
}

group = "io.github.moashrafff.bankCardValidator"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    testImplementation(kotlin("test"))
    testImplementation("junit:junit:4.13.2")
}

tasks.test {
    useJUnitPlatform()
}