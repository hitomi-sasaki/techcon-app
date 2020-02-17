import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

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
    implementation("io.ktor:ktor-auth:${Deps.ktorVersion}")
    implementation("io.ktor:ktor-auth-jwt:${Deps.ktorVersion}")
    implementation("ch.qos.logback:logback-classic:1.2.3")
    implementation("org.jetbrains.exposed:exposed:${ServerDeps.exposedVersion}")
    implementation("mysql:mysql-connector-java:${ServerDeps.mysqlConnectorVersion}")
    implementation("com.zaxxer:HikariCP:${ServerDeps.hikariVersion}")
    implementation("org.kodein.di:kodein-di-generic-jvm:${Deps.kodein}")
    implementation("org.kodein.di:kodein-di-framework-ktor-server-jvm:${Deps.kodein}")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

tasks.withType<ShadowJar> {
    baseName = "server"
    classifier = null
    version = null
    manifest {}
}

tasks.register("initializeDB", JavaExec::class) {
    group = "development"
    description = "setup DB schema and initial records."
    main = "jp.gree.techcon.server.task.InitializeDBKt"
    classpath = sourceSets.getByName("main").runtimeClasspath
}