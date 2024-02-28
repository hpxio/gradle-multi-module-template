rootProject.name = "gradle-multi-module-template"

include("gradle-multi-module-template-app")
include("gradle-multi-module-template-uat")
include("gradle-multi-module-template-client")

pluginManagement {
    val spotlessVersion: String by settings
    val springBootVersion: String by settings
    val springDependencyManagementVersion: String by settings

    plugins {
        id("com.diffplug.spotless") version spotlessVersion
        id("org.springframework.boot") version springBootVersion
        id("io.spring.dependency-management") version springDependencyManagementVersion
    }
}

/* settings to access TM Internal Artifacts */
dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}