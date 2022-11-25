
/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
object Dependency {

    object Test {
        // coroutine
        val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutine}"
        // junit5
        object JUnit {
            // runtime
            const val engine = "org.junit.jupiter:junit-jupiter-engine:${Version.junit}"
            // - for JUnit4 compatibility
            const val vintageEngine = "org.junit.vintage:junit-vintage-engine:${Version.junit}"
            // - for UI Test
            const val instrumentalEngine = "de.mannodermaus.junit5:android-test-runner:${Version.junitPlugin}"
            // apis
            const val api = "org.junit.jupiter:junit-jupiter-api:${Version.junit}"
            const val param = "org.junit.jupiter:junit-jupiter-params:${Version.junit}"
            const val instrumentalCore = "de.mannodermaus.junit5:android-test-core:${Version.junitPlugin}"
        }
        // espresso
        const val espresso = "androidx.test.espresso:espresso-core:${Version.espresso}"
    }

    object Kotlin {
        private const val version = "1.7.10"
        private const val versionCoroutine = "1.6.4"
        // lib
        private const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Version.kotlin}"
        private const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutine}"
        private const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutine}"
        // dependency pack
        val Android = listOf(stdlib, coroutineAndroid)
        val Native = listOf(stdlib, coroutineCore)
    }


    object AndroidX {
        // core
        val core = "androidx.core:core-ktx:${Version.AndroidX.core}"
        // appcompat
        val appCompat = "androidx.appcompat:appcompat:${Version.AndroidX.appCompat}"
        // collection
        val collection = "androidx.collection:collection-ktx:${Version.AndroidX.collection}"
        // lifecycle ( 2.5.1 ~ activity ktx too )
        val lifeCycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.AndroidX.lifecycle}"
        // recyclerview
        val recyclerView = "androidx.recyclerview:recyclerview:${Version.AndroidX.recyclerView}"
        // fragment
        val fragment = "androidx.fragment:fragment-ktx:${Version.AndroidX.fragment}"
        // startup
        val startUp = "androidx.startup:startup-runtime:${Version.AndroidX.startUp}"
    }



    object Network {
        // -- OkHttp3
        val okhttp = "com.squareup.okhttp3:okhttp:${Version.okHttp3}"
        val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:${Version.okHttp3}"
        // -- Retrofit
        val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
        val retrofitConverterJackson = "com.squareup.retrofit2:converter-jackson:${Version.retrofit}"

    }

    object Util {
        // Debugging
        val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Version.leakCanary}"
        // DI
        val hiltCore = "com.google.dagger:hilt-android:${Version.hilt}"
        val hiltCompiler = "com.google.dagger:hilt-compiler:${Version.hilt}"
        // parser
        val jacksonCore = "com.fasterxml.jackson.core:jackson-core:${Version.jackson}"
        val jacksonDatabind = "com.fasterxml.jackson.core:jackson-databind:${Version.jackson}"
        val jacksonAnnotation = "com.fasterxml.jackson.core:jackson-annotations:${Version.jackson}"
        val jacksonKotlin = "com.fasterxml.jackson.module:jackson-module-kotlin:${Version.jackson}"
        // logger
        val timber = "com.jakewharton.timber:timber:${Version.timber}"
    }

}