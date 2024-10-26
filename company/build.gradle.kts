import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    jvm()

    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_21)
        }
    }

    sourceSets {
        androidMain.dependencies {}

        commonMain.dependencies {
            implementation(projects.database)
            implementation(projects.network)
            implementation(projects.types)

            // Coroutines
            implementation(libs.kotlinx.coroutines.core)
        }

        jvmMain.dependencies {
            // Coroutines
            implementation(libs.kotlinx.coroutines.swing)
        }
    }
}

android {
    namespace = "org.clo.company"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}