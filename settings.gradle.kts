pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Movie"
include(":app")
include(":core:source")
include(":core:model")
include(":core:designsystem")
include(":feature:home")
include(":feature:favorite")
include(":feature:detailmovie")
include(":feature:search")
