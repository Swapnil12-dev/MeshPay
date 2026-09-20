package com.mesh.controller;

import com.mesh.entity.Account;
import com.mesh.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class AccountControllor {

    @Autowired
    private AccountService accountService;

    @GetMapping("/api/account/{vpa}/balance")
    public BigDecimal getBalance(@PathVariable String vpa){

        return accountService.getBalance(vpa);

    }

}
