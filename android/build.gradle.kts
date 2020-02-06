plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(AndroidDeps.compileSdkVersion)
    defaultConfig {
        applicationId = "jp.gree.techcon"
        minSdkVersion(AndroidDeps.minSdkVersion)
        targetSdkVersion(AndroidDeps.targetSdkVersion)
        versionCode = AndroidDeps.versionCode
        versionName = AndroidDeps.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
    buildTypes {
        val release by getting {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    composeOptions {
        kotlinCompilerExtensionVersion = AndroidDeps.composeVersion
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> { kotlinOptions.jvmTarget = "1.8" }
    packagingOptions {
        exclude("META-INF/*.kotlin_module")
    }
}

dependencies {
    implementation(project(":common"))
    implementation(fileTree(mapOf("include" to listOf("*.jar"), "dir" to "libs")))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Deps.kotlinVersion}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Deps.coroutineVersion}")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Deps.serializeVersion}")
    implementation("io.ktor:ktor-client-android:${Deps.ktorVersion}")
    implementation("io.ktor:ktor-client-serialization-jvm:${Deps.ktorVersion}")
    implementation("org.kodein.di:kodein-di-erased:${Deps.kodein}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${AndroidDeps.ktxVersion}")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:${AndroidDeps.ktxVersion}")
    implementation("androidx.navigation:navigation-fragment-ktx:${AndroidDeps.navigationVersion}")
    implementation("androidx.navigation:navigation-ui-ktx:${AndroidDeps.navigationVersion}")
    implementation("androidx.appcompat:appcompat:${AndroidDeps.appCompatVersion}")
    implementation("androidx.constraintlayout:constraintlayout:2.0.0-beta4")
    implementation("androidx.ui:ui-tooling:${AndroidDeps.composeVersion}")
    implementation("androidx.ui:ui-layout:${AndroidDeps.composeVersion}")
    implementation("androidx.ui:ui-foundation:${AndroidDeps.composeVersion}")
    implementation("androidx.ui:ui-framework:${AndroidDeps.composeVersion}")
    implementation("androidx.ui:ui-animation:${AndroidDeps.composeVersion}")
    implementation("androidx.ui:ui-material:${AndroidDeps.composeVersion}")
    implementation("dev.chrisbanes:insetter-ktx:${AndroidDeps.insetterVersion}")
    implementation("androidx.core:core-ktx:${AndroidDeps.coreVersion}")
    implementation("com.google.android.material:material:${AndroidDeps.materialVersion}")
    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test.ext:junit:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")
}
