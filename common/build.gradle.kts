import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("com.android.library")
    id("com.squareup.sqldelight")
}

repositories {
    google()
    jcenter()
    mavenCentral()
}


android {
    compileSdkVersion(AndroidDeps.compileSdkVersion)
    defaultConfig {
        minSdkVersion(AndroidDeps.minSdkVersion)
        targetSdkVersion(AndroidDeps.targetSdkVersion)
        versionCode = AndroidDeps.versionCode
        versionName = AndroidDeps.versionName
    }
    buildTypes {
        val release by getting {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
    sourceSets.forEach {
        it.manifest.srcFile("src/androidMain/AndroidManifest.xml")
    }
}

kotlin {
    jvm()
    android("android") {
    }
    // This is for iPhone emulator
    // Switch here to iosArm64 (or iosArm32) to build library for iPhone device
    iosX64("ios") {
        binaries {
            framework {
                freeCompilerArgs += "-Xobjc-generics"
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:${Deps.coroutineVersion}")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:${Deps.serializeVersion}")
                implementation("io.ktor:ktor-client-core:${Deps.ktorVersion}")
                implementation("io.ktor:ktor-client-serialization:${Deps.ktorVersion}")
                implementation("com.squareup.sqldelight:coroutines-extensions:${Deps.sqldelight}")
                implementation("org.kodein.di:kodein-di-erased:${Deps.kodein}")
            }
        }
        val mobileMain by creating {
            dependsOn(commonMain)
        }
        val iosMain by getting {
            dependsOn(mobileMain)

            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:${Deps.coroutineVersion}")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-native:${Deps.coroutineVersion}")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-native:${Deps.serializeVersion}")
                implementation("io.ktor:ktor-client-ios:${Deps.ktorVersion}")
                implementation("io.ktor:ktor-client-serialization-native:${Deps.ktorVersion}")
                implementation("com.squareup.sqldelight:ios-driver:${Deps.sqldelight}")
            }
        }
        val androidMain by getting {
            dependsOn(mobileMain)

            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:${Deps.coroutineVersion}")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Deps.coroutineVersion}")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Deps.serializeVersion}")
                implementation("androidx.lifecycle:lifecycle-runtime-ktx:${AndroidDeps.ktxVersion}")
                implementation("androidx.lifecycle:lifecycle-livedata-ktx:${AndroidDeps.ktxVersion}")
                implementation("io.ktor:ktor-client-android:${Deps.ktorVersion}")
                implementation("io.ktor:ktor-client-serialization-jvm:${Deps.ktorVersion}")
                implementation("com.squareup.sqldelight:android-driver:${Deps.sqldelight}")
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Deps.kotlinVersion}")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:${Deps.coroutineVersion}")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Deps.serializeVersion}")
                implementation("io.ktor:ktor-client-core-jvm:${Deps.ktorVersion}")
                implementation("io.ktor:ktor-client-serialization-jvm:${Deps.ktorVersion}")
                implementation("com.squareup.sqldelight:sqlite-driver:${Deps.sqldelight}")
            }
        }
    }
}

sqldelight {
    database("AppDatabase") {
        packageName = "jp.gree.techcon.common"
        sourceFolders = listOf("sqldelight")
    }
}

// This task attaches native framework built from ios module to Xcode project
// (see iosApp directory). Don't run this task directly,
// Xcode runs this task itself during its build process.
// Before opening the project from iosApp directory in Xcode,
// make sure all Gradle infrastructure exists (gradle.wrapper, gradlew).
task("copyFramework") {
    val buildType = project.findProperty("kotlin.build.type") as? String ?: "DEBUG"
    val target = project.findProperty("kotlin.target") as? String ?: "ios"
    dependsOn(kotlin.targets.getByName<KotlinNativeTarget>(target).binaries.getFramework(buildType).linkTask)

    doLast {
        val srcFile =
            kotlin.targets.getByName<KotlinNativeTarget>(target).binaries.getFramework(buildType)
                .outputFile
        val targetDir = findProperty("configuration.build.dir") as String
        copy {
            from(srcFile.parent)
            into(targetDir)
            include("common.framework/**")
            include("common.framework.dSYM")
        }
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.compilerArgs = listOf("-Xmx512m", "-XX:MaxMetaspaceSize=256m")
}
