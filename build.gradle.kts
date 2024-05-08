// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id ("com.google.dagger.hilt.android") version ("2.51.1") apply false
    id ("org.jetbrains.kotlin.jvm") version "1.9.0"
    id("com.google.devtools.ksp") version "1.9.20-1.0.14" apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
}