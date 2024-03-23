package com.ena.bank.processing.controller;

import com.ena.bank.processing.dto.ExchangeMoneyDTO;
import com.ena.bank.processing.dto.NewAccountDTO;
import com.ena.bank.processing.dto.PutAccountMoneyDTO;
import com.ena.bank.processing.model.AccountEntity;
import com.ena.bank.processing.service.AccountService;
import com.ena.bank.processing.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("processing")
@RequiredArgsConstructor
public class ProcessingController {

    private final AccountService accountService;
    private final ExchangeService exchangeService;

    @PostMapping("/account")
    public AccountEntity createAccount(@RequestBody NewAccountDTO account) {
        return accountService.createNewAccount(account);
    }

    @PutMapping("/account/{id}")
    public AccountEntity putMoney(@PathVariable("id") Long accountId, @RequestBody PutAccountMoneyDTO data) {
        return accountService.addMoneyToAccount(data.getUid(), accountId, data.getMoney());
    }

    @PutMapping("/exchange/{uid}")
    public BigDecimal exchange(@PathVariable("uid") String uid, @RequestBody ExchangeMoneyDTO data) {
        return  exchangeService.exchangeCurrency(uid, data.getFromAccount(), data.getToAccount(), data.getAmount());
    }

    @GetMapping("/accounts/{user}")
    public List<AccountEntity> getAllAccount(@PathVariable("user") Long user) {
        return accountService.getAllAccount(user);
    }
}
