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
                "latestVersionCode", 1,
                "latestVersionName", "1.0.0",
                "downloadUrl", "https://meshpay-backend-latest.onrender.com/download/MeshPay.apk", // Or Google Drive/GitHub link
                "forceUpdate", false
        ));
    }
}