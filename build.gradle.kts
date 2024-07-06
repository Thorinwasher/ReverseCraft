plugins {
    id("java")
}

group = "dev.thorinwasher"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://repo.spongepowered.org/repository/maven-public/")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("net.minestom:minestom-snapshots:0129aedae3")
    implementation("com.google.guava:guava:33.2.1-jre")
    implementation("com.github.xaguzman:pathfinding:0.2.6")
    implementation("dev.thorinwasher:minestruct:1.0-SNAPSHOT")
    implementation("org.spongepowered:noise:2.0.0-SNAPSHOT")
}

tasks.test {
    useJUnitPlatform()
}