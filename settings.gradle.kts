pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "EffectiveMobileApplication"
include(":app")
include(":shared:tickets:core")
include(":feature:tickets:musicaltickets")
include(":feature:tickets:searchtickets")
include(":feature:tickets:showtickets")
include(":feature:tickets:ticketstocountry")
include(":feature:tickets:firetickets")
include(":feature:tickets:weekends")
include(":feature:tickets:anywheretickets")
include(":feature:screens:screengps")
include(":feature:screens:screenhotels")
include(":feature:screens:screenprofile")
include(":feature:screens:screensubscribers")
