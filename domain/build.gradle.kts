plugins {
    id("java-library")
    kotlin("jvm")
}

java {
    sourceCompatibility = Application.jvmSourceCompat
    targetCompatibility = Application.jvmTargetCompat
}

dependencies {
    Dependency.Kotlin.Native.forEach(::implementation)
    // Test setup
    testRuntimeOnly(Dependency.Test.JUnit.engine)
    Dependency.Test.JUnit.API.forEach(::testImplementation)
    testImplementation(Dependency.Test.coroutine)
}
tasks.withType(Test::class) {
    useJUnitPlatform()
}