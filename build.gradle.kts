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
        classpath("com.github.jengelman.gradle.plugins:shadow:${ServerDeps.shadowVersion}")
        classpath("com.squareup.sqldelight:gradle-plugin:${Deps.sqldelight}")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}
