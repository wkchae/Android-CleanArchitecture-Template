plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("de.mannodermaus.android-junit5") version "1.8.2.1"
}

android {
    namespace = Application.namespace("presentation")
    compileSdk = Application.compileSdk

    defaultConfig {
        minSdk = Application.minSdk
        targetSdk = Application.targetSdk

        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunnerArguments["runnerBuilder"] = "de.mannodermaus.junit5.AndroidJUnit5Builder"
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
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    // Project
    implementation(project(":domain"))

    // Util
    kapt(Dependency.Util.Hilt.compiler)
    implementation(Dependency.Util.Hilt.core)

    // UI

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.7.0")


    // Test
    // Test: UnitTest
    testRuntimeOnly(Dependency.Test.JUnit.engine)
    Dependency.Test.JUnit.API.forEach(::testImplementation)
    testImplementation(Dependency.Test.coroutine)
    // Test: Instrumental Test
    androidTestRuntimeOnly(Dependency.Test.JUnit.instrumentalEngine)
    androidTestImplementation(Dependency.Test.Espresso.espresso)
    Dependency.Test.JUnit.API.forEach(::androidTestImplementation)
    androidTestImplementation(Dependency.Test.JUnit.instrumentalCore)
}