import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("java-library")
    kotlin("jvm")
}

java {
    sourceCompatibility = Application.jvmSourceCompat
    targetCompatibility = Application.jvmTargetCompat
}

dependencies {
    // Kotlin setup
    addKotlin(isAndroid = false)
    // Test setup
    addTestDependencies()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.freeCompilerArgs += listOf(
        "-Xopt-in=kotlin.contracts.ExperimentalContracts"   // use contract for syntactic contracts
    )
}