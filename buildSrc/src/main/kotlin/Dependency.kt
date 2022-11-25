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
            const val espresso = "androidx.test.espresso:espresso-core:$versionEspresso"
            // for JUnit 4
            private const val testRunner = "androidx.test:runner:1.5.1"
        }

    }

    object Kotlin {
        private const val version = "1.7.10"
        private const val versionCoroutine = "1.6.4"
        // lib
        private const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:$version"
        private const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$versionCoroutine"
        private const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$versionCoroutine"
        // dependency pack
        val Android = listOf(stdlib, coroutineAndroid)
        val Native = listOf(stdlib, coroutineCore)
    }


    object AndroidX {
        // core
        private val versionCore = "1.9.0"
        private val core = "androidx.core:core-ktx:$versionCore"
        // appcompat
        private val versionAppCompat = "1.5.1"
        private val appCompat = "androidx.appcompat:appcompat:${versionAppCompat}"
        // collection
        private val versionCollection = "1.2.0"
        private val collection = "androidx.collection:collection-ktx:$versionCollection"
        // lifecycle ( 2.5.1 ~ activity ktx too )
        private val versionLifeCycle = "2.5.1"
        private val lifeCycle = "androidx.lifecycle:lifecycle-runtime-ktx:$versionLifeCycle"
        // recyclerview
        private val versionRecyclerView = "1.2.1"
        private val recyclerView = "androidx.recyclerview:recyclerview:$versionRecyclerView"
        // fragment
        private val versionFragment = "1.5.4"
        private val fragment = "androidx.fragment:fragment-ktx:$versionFragment"

        // startup
        private val versionStartUp = "1.1.1"
        private val startUp = "androidx.startup:startup-runtime:$versionStartUp"


    }



    object Network {
        class OkHTTP {
            private val version = "4.10.0"
            // lib
            private val okhttp = "com.squareup.okhttp3:okhttp:$version"
            private val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:$version"
            // dependency
            operator fun invoke() = listOf(okhttp, okhttpLogging)
        }
        class Retrofit {
            private val version = "2.9.0"
            private val retrofit = "com.squareup.retrofit2:retrofit:$version"
            private val retrofitJackson = "com.squareup.retrofit2:converter-jackson:$version"
            // dependency
            operator fun invoke() = listOf(retrofit, retrofitJackson)
        }

    }

    object Util {
        // Debugging
        private val versionLeakCanary = "2.10"
        val leakCanary = "com.squareup.leakcanary:leakcanary-android:$versionLeakCanary"
        // DI
        object Hilt {
            private const val version = "2.44.2"
            val core = "com.google.dagger:hilt-android:$version"
            val compiler = "com.google.dagger:hilt-compiler:$version"
        }
        // parser
        class Jackson {
            // 2.14.0 compatibility (jdk8 + / android sdk 26+)
            private val version = "2.14.0"
            // lib
            private val core = "com.fasterxml.jackson.core:jackson-core:$version"
            private val databind = "com.fasterxml.jackson.core:jackson-databind:$version"
            private val annotation = "com.fasterxml.jackson.core:jackson-annotations:$version"
            private val kotlin = "com.fasterxml.jackson.module:jackson-module-kotlin:$version"
            operator fun invoke() = listOf(core, databind, annotation, kotlin)
        }
        // logger
        class Timber {
            private val version = "5.0.1"
            private val timber = "com.jakewharton.timber:timber:$version"
            operator fun invoke() = timber
        }
        // debugger
        class LeakCanary {
        }
    }

}