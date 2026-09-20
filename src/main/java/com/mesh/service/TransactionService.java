package com.mesh.service;

import java.util.List;

import com.mesh.entity.Transaction;

public interface TransactionService {

    List<Transaction> getAllTransactions();
    List<Transaction> getTransactionsByVpa(String vpa);

}