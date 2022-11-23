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
    testImplementation(Dependency.Test.jUnit)

}
tasks.withType(Test::class) {
    useJUnitPlatform()
}