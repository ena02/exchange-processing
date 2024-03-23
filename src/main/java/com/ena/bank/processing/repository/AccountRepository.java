package com.ena.bank.processing.repository;

import com.ena.bank.processing.model.AccountEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<AccountEntity, Long> {
    List<AccountEntity> findByUserId(Long userId);
}
