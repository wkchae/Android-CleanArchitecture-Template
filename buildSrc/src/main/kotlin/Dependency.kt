
/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
object Dependency {

    object Test {
        // coroutine
        const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutine}"
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
        // Network
        object Network {
            const val mockWebserver = "com.squareup.okhttp3:mockwebserver:${Version.okHttp3}"
        }
        // espresso
        const val espresso = "androidx.test.espresso:espresso-core:${Version.espresso}"
        // assertJ
        const val assertJ = "org.assertj:assertj-core:${Version.assertJ}"
        // test core
        const val androidTestCore = "androidx.test:core-ktx:${Version.AndroidX.testCore}"
        // robolectric
        const val roboletric = "org.robolectric:robolectric:4.9"
    }

    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Version.kotlin}"
        const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutine}"
        const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutine}"
    }

    object AndroidX {
        // core
        const val core = "androidx.core:core-ktx:${Version.AndroidX.core}"
        // appcompat
        const val appCompat = "androidx.appcompat:appcompat:${Version.AndroidX.appCompat}"
        // collection
        const val collection = "androidx.collection:collection-ktx:${Version.AndroidX.collection}"
        // lifecycle ( 2.5.1 ~ activity ktx too )
        const val lifeCycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.AndroidX.lifecycle}"
        // recyclerview
        const val recyclerView = "androidx.recyclerview:recyclerview:${Version.AndroidX.recyclerView}"
        // fragment
        const val fragment = "androidx.fragment:fragment-ktx:${Version.AndroidX.fragment}"
        // splash screen api 12
        const val splashScreen = "androidx.core:core-splashscreen:${Version.AndroidX.splashScreen}"
        // startup
        const val startUp = "androidx.startup:startup-runtime:${Version.AndroidX.startUp}"
    }

    object UI {
        // google material design
        const val material = "com.google.android.material:material:${Version.material}"
    }

    object Network {
        // -- OkHttp3
        const val okhttp = "com.squareup.okhttp3:okhttp:${Version.okHttp3}"
        const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:${Version.okHttp3}"
        // -- Retrofit
        const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
        const val retrofitConverterJackson = "com.squareup.retrofit2:converter-jackson:${Version.retrofit}"

    }

    object Database {
        // Room
        const val room = "androidx.room:room-runtime:${Version.room}"
        const val roomKtx = "androidx.room:room-ktx:${Version.room}"
        const val roomCompiler = "androidx.room:room-compiler:${Version.room}"

    }

    object Util {
        // Debugging
        const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Version.leakCanary}"
        // DI
        const val hiltCore = "com.google.dagger:hilt-android:${Version.hilt}"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:${Version.hilt}"
        // parser
        const val jacksonCore = "com.fasterxml.jackson.core:jackson-core:${Version.jackson}"
        const val jacksonDatabind = "com.fasterxml.jackson.core:jackson-databind:${Version.jackson}"
        const val jacksonAnnotation = "com.fasterxml.jackson.core:jackson-annotations:${Version.jackson}"
        const val jacksonKotlin = "com.fasterxml.jackson.module:jackson-module-kotlin:${Version.jackson}"
        // logger
        const val timber = "com.jakewharton.timber:timber:${Version.timber}"
    }

}