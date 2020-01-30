import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    application
    id("kotlin")
    id("com.github.johnrengelman.shadow")
}

group = "jp.gree.techcon"
version = "0.0.1"

application {
    mainClassName = "io.ktor.server.netty.EngineMain"
}

sourceSets {
    getByName("main").java.srcDir("src")
    getByName("main").resources.srcDir("resources")
}

repositories {
    google()
    jcenter()
}

dependencies {
    implementation(project(":common"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Deps.kotlinVersion}")
    implementation("io.ktor:ktor-serialization:${Deps.ktorVersion}")
    implementation("io.ktor:ktor-server-netty:${Deps.ktorVersion}")
    implementation("io.ktor:ktor-gson:${Deps.ktorVersion}")
    implementation("io.ktor:ktor-locations:${Deps.ktorVersion}")
    implementation("ch.qos.logback:logback-classic:1.2.3")
}

tasks.withType<ShadowJar> {
    baseName = "server"
    classifier = null
    version = null
    manifest {}
}
