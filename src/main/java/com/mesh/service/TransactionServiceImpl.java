package com.mesh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mesh.entity.Transaction;
import com.mesh.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Transaction> getAllTransactions() {

        return transactionRepository.findAll();
    }
    @Override
    public List<Transaction> getTransactionsByVpa(String vpa) {

        return transactionRepository
                .findBySenderVpaOrReceiverVpa(vpa, vpa);
    }
}