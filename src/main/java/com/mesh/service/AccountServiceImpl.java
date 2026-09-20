package com.mesh.service;

import com.mesh.entity.Account;
import com.mesh.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;



    @Override
    public BigDecimal getBalance(String vpa) {
        Account account = accountRepository.findById(vpa).orElseThrow(()->new RuntimeException());
        return account.getBalance();


    }

}
