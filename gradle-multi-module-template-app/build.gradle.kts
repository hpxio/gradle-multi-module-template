dependencies {
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	
	developmentOnly("org.springframework.boot:spring-boot-devtools")

	/* logging provider */
	implementation("org.apache.logging.log4j:log4j-api")
    implementation("org.apache.logging.log4j:log4j-core")
	
	/* spring-web provider */
	implementation("org.springframework.boot:spring-boot-starter-web"){
		exclude("org.springframework.boot:spring-boot-starter-logging")
	}
	implementation("org.springframework.boot:spring-boot-starter-log4j2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}