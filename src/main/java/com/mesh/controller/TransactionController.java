package com.mesh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mesh.entity.Transaction;
import com.mesh.service.TransactionService;

@RestController
@RequestMapping("/api/payments")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/transactions")
    public List<Transaction> getTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/transactions/{vpa}")
    public List<Transaction> getUserTransactions(
            @PathVariable String vpa) {

        return transactionService.getTransactionsByVpa(vpa);
    }
}