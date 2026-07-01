import java.nio.file.Paths
import kotlin.io.path.moveTo
import kotlin.io.path.ExperimentalPathApi
import org.gradle.api.Project
import org.gradle.kotlin.dsl.*

plugins {
    java
    kotlin("jvm") version "1.7.20"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

subprojects {
    apply(plugin = "java")
}

var modVersion: String = project.property("global_version").toString()
//var modVersion: String = providers.gradleProperty("global_version")
var mcCore = project(":mccore")
var mcInterfaceForge1122 = project(":mcinterfaceforge1122")
var mcInterfaceForge1165 = project(":mcinterfaceforge1165")
var mcInterfaceForge1201 = project(":mcinterfaceforge1201")

tasks.register("buildCore") {
    doFirst {
        // Run your Python script here if needed
        //exec {
        //    commandLine("python", "./transformers/1-12-2_1-16-5_ID_transformer.py")
        //    commandLine("python3", "./transformers/json_univ_transformer.py")
        //}
        preBuild()
    }
    dependsOn(mcCore.tasks.build)
    doLast {
        moveToOut(mcCore, "core")
    }
}

tasks.register("buildForge1122") {
    doFirst {
        // Run your Python script here if needed
        //exec {
        //    commandLine("python", "./transformers/1-12-2_1-16-5_ID_transformer.py", "--reverse")
        //    commandLine("python3", "./transformers/json_univ_transformer.py")
        //}
        preBuild()
    }
    dependsOn(mcInterfaceForge1122.tasks.build)
    doLast {
        moveToOut(mcInterfaceForge1122, "1.12.2")
    }
}

tasks.register("buildForge1165") {
    doFirst {
        // Run your Python script here if needed
        //exec {
        //    commandLine("python", "./transformers/1-12-2_1-16-5_ID_transformer.py")
        //    commandLine("python3", "./transformers/json_univ_transformer.py")
        //}
        preBuild()
    }
    dependsOn(mcInterfaceForge1165.tasks.build)
    doLast {
        moveToOut(mcInterfaceForge1165, "1.16.5")
    }
}

/*tasks.register("buildForge1182") {
    doFirst { preBuild() }
    doLast {
        moveToOut(mcInterfaceForge1182, "1.18.2")
    }
    dependsOn(mcInterfaceForge1182.tasks.build)
}

tasks.register("buildForge1192") {
    doFirst { preBuild() }
    doLast {
        moveToOut(mcInterfaceForge1192, "1.19.2")
    }
    dependsOn(mcInterfaceForge1192.tasks.build)
}*/

tasks.register("buildForge1201") {
    doFirst { preBuild() }
    doLast {
        moveToOut(mcInterfaceForge1201, "1.20.1")
    }
    dependsOn(mcInterfaceForge1201.tasks.build)
}

tasks.register("buildForgeAll") {
    // Start by generating the 1.12.2, then run Python script, then 1.16.5
    dependsOn(tasks.getByName("buildForge1122"))
    dependsOn(tasks.getByName("buildForge1165"))
    dependsOn(tasks.getByName("buildForge1201"))
}

@OptIn(ExperimentalPathApi::class)
fun moveToOut(subProject: Project, versionStr: String) {
    mkdir("out/$versionStr")
    val jarName = "Immersive Vehicles Vanity-${subProject.version}.jar"
    Paths.get("${subProject.projectDir.canonicalPath}/build/libs/$jarName")
        .moveTo(Paths.get("${project.projectDir.canonicalPath}/out/$jarName"), true)
}

fun preBuild() {
    project.projectDir.canonicalFile.walk()
        .filter { it.name == "gradle.properties" || it.name == "mcmod.info" || it.name == "ForgePackLoader.java" || it.name == "mods.toml"}
        .forEach { it.writeText(it.readText()
            .replace(Regex("mod_version=(.+)"), "mod_version=$modVersion")
            .replace(Regex("\"version\": \"[^\"]*\""), "\"version\": \"$modVersion\"")
            .replace(Regex("\"version\"=\"[^\"]*\""), "\"version\"=\"$modVersion\"")
            .replace(Regex("MODVER = \"[^\"]*\";"), "MODVER = \"$modVersion\";")) }
}

subprojects {
    tasks.withType<Jar>().configureEach {
        duplicatesStrategy = DuplicatesStrategy.INCLUDE
    }
}

