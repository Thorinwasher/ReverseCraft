plugins {
    id("java")
}

group = "org.sgrewritten"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("net.minestom:minestom-snapshots:f1d5940855")
    implementation("com.google.guava:guava:33.2.1-jre")
}

tasks.test {
    useJUnitPlatform()
}