import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = Application.namespace("data")
    compileSdk = Application.compileSdk

    defaultConfig {
        minSdk = Application.minSdk
        targetSdk = Application.targetSdk

        multiDexEnabled = true
    }
}

dependencies {
    // Module
    implementation(project(":domain"))

    // Dependency
    addKotlin(isAndroid = true)
    addHilt()
    addRetrofit()
    addRoom()

    // Test
    addTestDependencies()
    testImplementation("org.assertj:assertj-core:3.23.1")
    testImplementation(Dependency.Test.Network.mockWebserver)
}