val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val koin_version:String by project
plugins {
    kotlin("jvm") version "1.8.10"
    id("io.ktor.plugin") version "2.2.3"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.8.0"

}

group = "com.example"
version = "0.0.1"
application {
    mainClass.set("com.example.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
    implementation("mysql:mysql-connector-java:8.0.28")
    implementation("org.ktorm:ktorm-core:3.4.0")
    implementation("io.ktor:ktor-serialization-gson-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktor_version")
    implementation("io.ktor:ktor-serialization-gson-jvm:$ktor_version")
    implementation ("io.ktor:ktor-serialization:$ktor_version")
    implementation("io.ktor:ktor-serialization-gson:$ktor_version")
    implementation("com.zaxxer:HikariCP:3.4.0")
    implementation("org.ktorm:ktorm-jackson:3.4.0")
    implementation("io.ktor:ktor-serialization-gson-jvm:$ktor_version")
    implementation ("io.ktor:ktor-serialization:$ktor_version")
    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")

    implementation ("io.ktor:ktor-client-core:$ktor_version")
    implementation ("io.ktor:ktor-client-cio:$ktor_version")
    implementation("io.ktor:ktor-client-auth-jvm:2.1.0")
    implementation("io.ktor:ktor-server-default-headers:$ktor_version")
    implementation("io.ktor:ktor-server-default-headers:$ktor_version")
     implementation ("ch.qos.logback:logback-classic:1.2.6")
    implementation("ch.qos.logback:logback-core:1.2.6")
    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
     implementation("mysql:mysql-connector-java:8.0.29")
      implementation ("io.ktor:ktor-serialization:$ktor_version")
    implementation("io.ktor:ktor-serialization-gson:$ktor_version")
    implementation ("io.ktor:ktor-server-content-negotiation:$ktor_version")
    implementation("io.ktor:ktor-server-request-validation:$ktor_version")
    implementation("io.ktor:ktor-server-status-pages:$ktor_version")
    implementation("io.ktor:ktor-server-auth:$ktor_version")
    implementation("io.ktor:ktor-server-status-pages:$ktor_version")
    implementation ("io.github.microutils:kotlin-logging-jvm:2.0.11")

}