package com.csye6225.cloud.controller;

import com.csye6225.cloud.service.DatabaseHealthIndicator;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.health.Status;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class HealthController {
    final DatabaseHealthIndicator databaseHealthIndicator;

    @GetMapping("/healthz")
    public ResponseEntity<String> getHealth() {
        HttpHeaders headers = getRequiredHeaders();
        if (Status.UP.equals(databaseHealthIndicator.health().getStatus()))
            return ResponseEntity.ok().headers(headers).build();
        else
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).headers(headers).build();
    }

    @PostMapping("/healthz")
    public ResponseEntity<String> postHealth() {
        return getMethodNotAllowedResponse();
    }

    @PutMapping("/healthz")
    public ResponseEntity<String> putHealth() {
        return getMethodNotAllowedResponse();
    }

    @PatchMapping("/healthz")
    public ResponseEntity<String> patchHealth() {
        return getMethodNotAllowedResponse();
    }

    @DeleteMapping("/healthz")
    public ResponseEntity<String> deleteHealth() {
        return getMethodNotAllowedResponse();
    }

    private ResponseEntity<String> getMethodNotAllowedResponse() {
        HttpHeaders headers = getRequiredHeaders();
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).headers(headers).build();
    }

    private HttpHeaders getRequiredHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        //For compatibility with HTTP/1.0 clients
        headers.add("Pragma", "no-cache");
        //Instructs the browser to block requests that try to "sniff" the MIME type
        headers.add("X-Content-Type-Options", "nosniff");

        return headers;
    }

}
