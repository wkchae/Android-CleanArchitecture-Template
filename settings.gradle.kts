//pluginManagement {
//    repositories {
//        gradlePluginPortal()
//        google()
//        mavenCentral()
//    }
//}
//dependencyResolutionManagement {
//    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
//    repositories {
//        google()
//        mavenCentral()
//    }
//}
rootProject.name = "clean_mvvm"
include(":app")

/**
 * layering clean-architecture
 * (1) Domain
 * (2) Data
 * (3) Presentation
 */
include(":domain")
include(":presentation")
include(":data")
