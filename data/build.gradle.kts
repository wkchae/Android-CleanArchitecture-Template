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
    addKotlin(isAndroid = true)
    addHilt()
    addRetrofit()


    // Test
    addTestDependencies()
    testImplementation(Dependency.Test.Network.mockWebserver)
}