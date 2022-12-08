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
    implementation("androidx.test:core-ktx:1.5.0")

    // Dependency
    addKotlin(isAndroid = true)
    addHilt()
    addRetrofit()
    addRoom()

    // Test
    addTestDependencies(needContextUnitTest = true)
    testImplementation(Dependency.Test.Network.mockWebserver)
}