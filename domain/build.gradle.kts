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