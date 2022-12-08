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

    addKotlin(isAndroid = true)

    // Util
    addHilt()

    // UI
    // AndroidX and basis
    bulkImplementation(listOf(
        Dependency.AndroidX.core,
        Dependency.AndroidX.appCompat,
        Dependency.AndroidX.lifeCycle,
        Dependency.UI.material,
    ))

    // Test
    addTestDependencies(needContextUnitTest = true, includeUiTest = true)
}