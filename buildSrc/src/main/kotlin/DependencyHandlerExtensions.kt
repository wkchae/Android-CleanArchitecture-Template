import org.gradle.api.artifacts.dsl.DependencyHandler

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */

fun DependencyHandler.addKotlin(isAndroid: Boolean = true) {
    // kotlin & coroutine
    implementation(Dependency.Kotlin.stdlib)
    implementation(Dependency.Kotlin.coroutineCore)
    // android
    if(isAndroid) {
        implementation(Dependency.Kotlin.coroutineAndroid)
    }
}

fun DependencyHandler.addRetrofit() {
    // okhttp
    implementation(Dependency.Network.okhttp)
    implementation(Dependency.Network.okhttpLogging)
    // retrofit
    implementation(Dependency.Network.retrofit)
    implementation(Dependency.Network.retrofitConverterJackson)
    // jackson
    implementation(Dependency.Util.jacksonCore)
    implementation(Dependency.Util.jacksonKotlin)
    implementation(Dependency.Util.jacksonAnnotation)
    implementation(Dependency.Util.jacksonDatabind)
}

fun DependencyHandler.addHilt() {
    kapt(Dependency.Util.hiltCompiler)
    implementation(Dependency.Util.hiltCore)
}

fun DependencyHandler.addRoom() {
    kapt(Dependency.Database.roomCompiler)
    implementation(Dependency.Database.room)
    implementation(Dependency.Database.roomKtx)
}

fun DependencyHandler.addTestDependencies(needContextUnitTest: Boolean = false, includeUiTest: Boolean = false) {
    // coroutine
    testImplementation(Dependency.Test.coroutine)
    // JUnit5
    testRuntimeOnly(Dependency.Test.JUnit.engine)
    testImplementation(Dependency.Test.JUnit.api)
    testImplementation(Dependency.Test.JUnit.param)
    // assertJ
    testImplementation(Dependency.Test.assertJ)
    if (needContextUnitTest) {
        testImplementation(Dependency.Test.JUnit.vintageEngine)
        testImplementation(Dependency.Test.androidTestCore)
        testImplementation("androidx.test.ext:junit-ktx:1.1.4")
        testImplementation(Dependency.Test.roboletric)
    }
    if (includeUiTest) {
        androidTestRuntimeOnly(Dependency.Test.JUnit.instrumentalEngine)
        androidTestImplementation(Dependency.Test.JUnit.instrumentalCore)
        androidTestImplementation(Dependency.Test.JUnit.api)
        androidTestImplementation(Dependency.Test.JUnit.param)
        androidTestImplementation(Dependency.Test.espresso)
    }
}


// restriction
private fun DependencyHandler.runtimeOnly(depName: String) {
    add("runtimeOnly", depName)
}
private fun DependencyHandler.testRuntimeOnly(depName: String) {
    add("testRuntimeOnly", depName)
}
private fun DependencyHandler.androidTestRuntimeOnly(depName: String) {
    add("androidTestRuntimeOnly", depName)
}
private fun DependencyHandler.compileOnly(depName: String) {
    add("compileOnly", depName)
}
private fun DependencyHandler.testCompileOnly(depName: String) {
    add("testCompileOnly", depName)
}
// implementations
private fun DependencyHandler.implementation(depName: String) {
    add("implementation", depName)
}
fun DependencyHandler.bulkImplementation(depNames: List<String>) {
    depNames.forEach(::implementation)
}
private fun DependencyHandler.debugImplementation(depName: String) {
    add("debugImplementation", depName)
}
private fun DependencyHandler.testImplementation(depName: String) {
    add("testImplementation", depName)
}
private fun DependencyHandler.androidTestImplementation(depName: String) {
    add("androidTestImplementation", depName)
}
// kapt
private fun DependencyHandler.kapt(depName: String) {
    add("kapt", depName)
}
// api
private fun DependencyHandler.api(depName: String) {
    add("api", depName)
}