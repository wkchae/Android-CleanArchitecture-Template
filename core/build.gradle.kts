plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = Application.namespace("core")
    compileSdk = Application.compileSdk

    defaultConfig {
        minSdk = Application.minSdk
        targetSdk = Application.compileSdk

        multiDexEnabled = true
    }

    buildTypes {
        release {
            release {
                consumerProguardFiles("consumer-rules.pro")
            }
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

    // logging
    api(Dependency.Util.timber)
}