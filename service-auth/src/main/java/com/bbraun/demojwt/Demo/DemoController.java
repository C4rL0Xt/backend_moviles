package com.bbraun.demojwt.Demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DemoController {
    
    @PostMapping(value = "demo")
    public ResponseEntity<Map<String, String>> welcome()
    {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Welcome from secure endpoint");
        return ResponseEntity.ok(response);
    }
}
