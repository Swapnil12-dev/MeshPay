package com.mesh.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/app")
public class AppVersionController {

    @GetMapping("/version")
    public ResponseEntity<Map<String, Object>> getLatestVersion() {
        return ResponseEntity.ok(Map.of(
                "latestVersionCode", 2,
                "latestVersionName", "1.1.0",
                "downloadUrl", "https://github.com/Swapnil12-dev/MeshPay_Frontend/releases/download/v1.1.0/app-debug.apk", // Or Google Drive/GitHub link
                "forceUpdate", false
        ));
    }
}