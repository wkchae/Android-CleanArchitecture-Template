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

    buildTypes {
        release {
            consumerProguardFiles("consumer-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = Application.jvmSourceCompat
        targetCompatibility = Application.jvmTargetCompat
    }
    kotlinOptions {
        jvmTarget = Application.jvmTarget
    }
}

dependencies {
    // Module
    implementation(project(":domain"))

    // Dependency
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.7.0")


    // Test
    // Test: UnitTest
    testRuntimeOnly(Dependency.Test.JUnit.engine)
    Dependency.Test.JUnit.API.forEach(::testImplementation)
    testImplementation(Dependency.Test.coroutine)
}