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
include(":lib:core:data:api")

// data/database
include(":lib:core:data:database")

// data/types
include(":lib:core:data:types")

// di
include(":lib:core:di")

// presentation
include(":lib:core:presentation")

// resources
include(":lib:core:resources")

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
