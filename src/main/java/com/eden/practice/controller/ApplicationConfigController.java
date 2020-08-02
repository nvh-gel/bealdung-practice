package com.eden.practice.controller;

import com.eden.practice.config.ApplicationProps;
import com.eden.practice.service.ApplicationPropService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApplicationConfigController {

    private final ApplicationPropService applicationPropService;

    public ApplicationConfigController(ApplicationPropService applicationPropService) {
        this.applicationPropService = applicationPropService;
    }

    @GetMapping("/config")
    public ResponseEntity<ApplicationProps> getYamlObjects() {
        return ResponseEntity.ok().body(applicationPropService.getApplicationProps());
    }
}
