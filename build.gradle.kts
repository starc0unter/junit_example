plugins {
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

allprojects {
    apply(plugin = "java")

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation("org.mockito:mockito-core:2.24.0")

        implementation("junit:junit:4.12")

        implementation("org.hamcrest:hamcrest-all:1.3")

        implementation("org.jetbrains:annotations:13.0")
    }
}