rootProject.name = "closs-kmp"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

include(":composeApp")

// core

// data/api
include(":core:data:api")

// data/database
include(":core:data:database")

// data/types
include(":core:data:types")

// di
include(":core:di")

// presentation
include(":core:presentation")

// resources
include(":core:resources")

// lib

// auth
include(":lib:auth:data")
include(":lib:auth:di")
include(":lib:auth:domain")
include(":lib:auth:presentation")

// home
include(":lib:home")

// contact
include(":lib:contact")

// contact-detail
include(":lib:contact-detail")

// dashboard
include(":lib:dashboard")
