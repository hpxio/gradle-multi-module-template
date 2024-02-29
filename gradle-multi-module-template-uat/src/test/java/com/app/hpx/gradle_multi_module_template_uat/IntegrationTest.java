package com.app.hpx.gradle_multi_module_template_uat;

import com.intuit.karate.junit5.Karate;

public class IntegrationTest {

    @Karate.Test
    Karate runHealthCheckUat() {
        return Karate.run().path("classpath:features");
    }
}
