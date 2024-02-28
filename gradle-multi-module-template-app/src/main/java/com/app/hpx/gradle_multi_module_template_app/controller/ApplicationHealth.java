package com.app.hpx.gradle_multi_module_template_app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationHealth {

    @GetMapping("/health")
    public ResponseEntity<String> getApplicationHealth() {
        return ResponseEntity.ok("Application Health : OK");
    }
}
