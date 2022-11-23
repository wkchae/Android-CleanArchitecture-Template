/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
object Dependency {
    object Test {
        private const val version_jUnit = "5.9.1"

        const val jUnitPlatform = "org.junit:junit-bom:$version_jUnit"
        const val jUnit = "org.junit.jupiter:junit-jupiter:$version_jUnit"
    }

    object Kotlin {
        private const val version = "1.7.10"
        private const val version_coroutine = "1.6.4"
        // lib
        private const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:$version"
        private const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version_coroutine"
        private const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version_coroutine"
        // dependency pack
        val Android = listOf(stdlib, coroutineAndroid)
        val Native = listOf(stdlib, coroutineCore)
    }

}