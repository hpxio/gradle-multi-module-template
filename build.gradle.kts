plugins {
	java
	id("com.diffplug.spotless")
	id("org.springframework.boot")
	id("io.spring.dependency-management")

	id("jacoco")
	id("jacoco-report-aggregation")
}

/* instruct jacoco to include given sub-modules for coverage report */
dependencies {
	jacocoAggregation(project(":gradle-multi-module-template-app"))
	jacocoAggregation(project(":gradle-multi-module-template-client"))
}

group = "com.app.hpx"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}


allprojects {
	apply(plugin = "java")
	apply(plugin = "com.diffplug.spotless")
	apply(plugin = "org.springframework.boot")

	configure<com.diffplug.gradle.spotless.SpotlessExtension> {
		java {
			removeUnusedImports()
			trimTrailingWhitespace()
			/*importOrderFile("eclipse.importorder")*/
			googleJavaFormat().aosp().reflowLongStrings()
		}
	}

	tasks.bootRun { enabled = false }
	tasks.bootJar { enabled = false }
	tasks.bootBuildImage { enabled = false }
}

subprojects {
	apply(plugin = "io.spring.dependency-management")
	
	apply<JacocoPlugin>()
	configure<JacocoPluginExtension> {
		toolVersion = property("jacocoVersion") as String
	}

	configurations {
		all {
			/* only junit 5 should be used */
			exclude("org.junit.vintage", "junit-vintage-engine")
			exclude("org.springframework.boot", "spring-boot-starter-logging")
		}
	}

	val springBootVersion: String by project
	dependencies {
		implementation("org.springframework.boot:spring-boot-starter")
		testImplementation("org.springframework.boot:spring-boot-starter-test")
	}
	
	tasks.withType<Test> {
		useJUnitPlatform()
	}
}

/* enable jar generation for app module */
project(":gradle-multi-module-template-app") {
	tasks.jar {enabled = true }
	tasks.bootJar { enabled = true }
	tasks.bootRun { enabled = true }
}

/* report is always generated after tests run */
tasks.test {
	finalizedBy(tasks.jacocoTestReport)
}

/* tests are required to run before generating the report */
tasks.jacocoTestReport {
	dependsOn(tasks.test)
}