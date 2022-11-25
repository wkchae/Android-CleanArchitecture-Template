// Top-level build file where you can add configuration options common to all sub-projects/modules.
//plugins {
//    id("org.jetbrains.kotlin.jvm") version "1.7.20" apply false
//    id 'com.android.application' version '7.3.1' apply false
//    id 'com.android.library' version '7.3.1' apply false
//    id 'org.jetbrains.kotlin.android' version '1.7.20' apply false
//}

import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

@Suppress("AndroidGradlePluginVersion")
buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:${Version.gradle}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Version.hilt}")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }

    afterEvaluate {
        tasks.withType<KotlinCompile> {
            kotlinOptions {
                freeCompilerArgs = freeCompilerArgs + listOf(
                    "-Xopt-in=kotlin.OptIn",
                    "-Xopt-in=kotlin.RequiresOptIn"
                )
            }
        }
    }
    tasks.withType(Test::class) {
        useJUnitPlatform()
        testLogging {
            events.addAll(arrayOf(TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED))
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
