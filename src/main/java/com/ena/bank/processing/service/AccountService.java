package com.ena.bank.processing.service;

import com.ena.bank.processing.dto.NewAccountDTO;
import com.ena.bank.processing.model.AccountEntity;
import com.ena.bank.processing.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    public final AccountRepository accountRepository;

    @Transactional
    public AccountEntity createNewAccount(NewAccountDTO dto) {
        var account = new AccountEntity();
        account.setCurrencyCode(dto.getCurrencyCode());
        account.setUserId(dto.getUserId());
        account.setBalance(new BigDecimal(0));

        var created = accountRepository.save(account);
        return created;
    }

    public AccountEntity addMoneyToAccount(String uid, Long accountId, BigDecimal money) {
        Optional<AccountEntity> account = accountRepository.findById(accountId);
        var result = account.map(acc -> {
            var balance = acc.getBalance().add(money);
            acc.setBalance(balance);
            return accountRepository.save(acc);
        }).orElseThrow(() -> new IllegalArgumentException("Account with ID " + accountId + " not found"));
        return result;
    }
}
