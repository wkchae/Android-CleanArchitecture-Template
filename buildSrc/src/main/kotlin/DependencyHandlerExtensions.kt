import org.gradle.api.artifacts.dsl.DependencyHandler

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
fun DependencyHandler.addRetrofit() {
    implementation(Dependency.Network.okhttp)
    implementation(Dependency.Network.okhttpLogging)
    implementation(Dependency.Network.retrofit)
    implementation(Dependency.Network.retrofitConverterJackson)
}




// restriction
private fun DependencyHandler.runtimeOnly(depName: String) {
    add("runtimeOnly", depName)
}
private fun DependencyHandler.testRuntimeOnly(depName: String) {
    add("testRuntimeOnly", depName)
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