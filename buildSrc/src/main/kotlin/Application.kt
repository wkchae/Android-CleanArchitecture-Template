import org.gradle.api.JavaVersion

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
object Application {
    const val ID = "com.hubtwork.clean_android.app"
    // about android SDK version
    const val compileSdk = 33
    const val minSdk = 21
    const val targetSdk = 33
    // about app version
    const val versionCode = 1
    const val versionName = "0.0.1"
    // about jvm
    const val jvmTarget = "11"
    val jvmTargetCompat = JavaVersion.VERSION_11
    val jvmSourceCompat = JavaVersion.VERSION_11
}

fun namespace(modulePath: String): String {
    return "com.hubtwork.clean_android.$modulePath"
}