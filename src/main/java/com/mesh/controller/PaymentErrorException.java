package com.mesh.controller;

public class PaymentErrorException extends RuntimeException {
    public PaymentErrorException(String message) {
        super("Error Processing payment");
    }
}
