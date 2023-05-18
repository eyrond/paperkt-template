plugins {
    kotlin("jvm") version "1.8.21"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "dev.eyrond.paperkt.example"
version = "1.0.0"

repositories {
    mavenCentral()
    // PaperMC repository.
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper", "paper-api", "1.19.4-R0.1-SNAPSHOT")
    implementation("dev.eyrond.paperkt", "core", "1.0.0")
}

kotlin {
    jvmToolchain(17)
}

tasks {
    processResources {
        expand("version" to project.version)
    }

    shadowJar {
        archiveFileName.set("plugin-${version}.jar")
        dependencyFilter.apply {
            // Exclude all the dependencies that are already provided by Paper.
            exclude(dependency("org.jetbrains:annotations"))
        }
    }

    test {
        useJUnitPlatform()
    }
}
