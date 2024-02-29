dependencies {
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	
	testImplementation("com.intuit.karate:karate-junit5:1.3.0") {
        exclude("ch.qos.logback", "logback-classic")
    }
	implementation("org.springframework.boot:spring-boot-starter-log4j2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.test {
    // base URL where artefact gets deployed
    systemProperty("base.url", System.getProperty("base.url"))
    // url component where callback is expected
    systemProperty("karate.env", System.getProperty("karate.env"))
    // pull karate options into the runtime
    systemProperty("karate.options", System.getProperty("karate.options"))
    
	// ensure tests are always run
    outputs.upToDateWhen { false }
    testLogging.showStandardStreams = true
}