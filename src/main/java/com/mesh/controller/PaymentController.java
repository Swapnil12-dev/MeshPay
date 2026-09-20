package com.mesh.controller;

import com.mesh.crypto.ServerKeyHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mesh.dto.ProcessPaymentRequest;
import com.mesh.service.SettlementService;

import java.util.Base64;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    
    @Autowired
    private SettlementService settlementService;

    
    @PostMapping("/process")
    public ResponseEntity<String> processPayment(
            @RequestBody ProcessPaymentRequest request)
            throws Exception {

        try{

            settlementService.processPayment(
                    request.getCiphertext());

            return ResponseEntity.ok("Payment processed Successfully ");

        }
        catch(Exception e){

            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }

    }

    @RestController
    @RequestMapping("/api/keys")
    public class KeyController {

        @Autowired
        private ServerKeyHolder serverKeyHolder;

        @GetMapping("/public")
        public String getPublicKey() {

            return Base64.getEncoder()
                    .encodeToString(
                            serverKeyHolder
                                    .getPublicKey()
                                    .getEncoded()
                    );
        }
    }
}