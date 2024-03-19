package com.ena.bank.processing.repository;

import com.ena.bank.processing.model.AccountEntity;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountEntity, Long> {

}
