package com.mesh.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mesh.entity.Transaction;

public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {
	
	Optional<Transaction> findBySenderVpa(String senderVpa);


    Optional<Transaction> findByPacketHash(String hash);
    List<Transaction> findBySenderVpaOrReceiverVpa(
            String senderVpa,
            String receiverVpa
    );

}