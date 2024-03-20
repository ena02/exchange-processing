package com.ena.bank.processing.controller;

import com.ena.bank.processing.dto.NewAccountDTO;
import com.ena.bank.processing.dto.PutAccountMoneyDTO;
import com.ena.bank.processing.model.AccountEntity;
import com.ena.bank.processing.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("processing")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/account")
    public AccountEntity createAccount(@RequestBody NewAccountDTO account) {
        return accountService.createNewAccount(account);
    }

    @PutMapping("/account/{id}")
    public AccountEntity putMoney(@PathVariable("id") Long accountId, @RequestBody PutAccountMoneyDTO data) {
        return accountService.addMoneyToAccount(data.getUid(), accountId, data.getMoney());
    }
}
