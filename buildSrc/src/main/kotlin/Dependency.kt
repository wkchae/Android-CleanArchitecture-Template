/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
object Dependency {
    object Test {
        private const val versionCoroutine = "1.6.4"
        const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$versionCoroutine"

        object JUnit {
            private const val version = "5.9.1"
            private const val plugin = "1.3.0"
            // runtime
            const val engine = "org.junit.jupiter:junit-jupiter-engine:$version"
            const val vintageEngine =
                "org.junit.vintage:junit-vintage-engine:$version" // for JUnit4 compatibility
            const val instrumentalEngine = "de.mannodermaus.junit5:android-test-runner:$plugin"
            // apis
            private const val api = "org.junit.jupiter:junit-jupiter-api:$version"
            private const val param = "org.junit.jupiter:junit-jupiter-params:$version"
            const val instrumentalCore = "de.mannodermaus.junit5:android-test-core:$plugin"
            val API = listOf(api, param)
        }
        object Espresso {
            private const val versionJUnitExt = "1.1.4"
            private const val versionEspresso = "3.5.0"
            const val jUnitExt = "androidx.test.ext:junit-ktx:$versionJUnitExt"
            private const val espresso = "androidx.test.espresso:espresso-core:$versionEspresso"
            private const val testRunner = "androidx.test:runner:1.5.1"
            val API = listOf(espresso, testRunner)
        }

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