plugins {
    id("java")
}

group = "br.com.iterasys"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.testng:testng:7.7.1")
    implementation("com.google.code.gson:gson:2.10.1")
    testImplementation("io.rest-assured:rest-assured:5.3.0")
}

tasks.test {
    useTestNG()
}