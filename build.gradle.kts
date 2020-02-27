buildscript {
    repositories {
        google()
        jcenter()
        maven (url = "https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${Deps.gradleVersion}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Deps.kotlinVersion}")
        classpath("org.jetbrains.kotlin:kotlin-serialization:${Deps.kotlinVersion}")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${AndroidDeps.navigationVersion}")
        classpath("com.google.gms:google-services:${AndroidDeps.googleServiceVersion}")
        classpath("com.github.jengelman.gradle.plugins:shadow:${ServerDeps.shadowVersion}")
        classpath("com.squareup.sqldelight:gradle-plugin:${Deps.sqldelightVersion}")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}
