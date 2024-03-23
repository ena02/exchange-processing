package com.ena.bank.processing.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExchangeMoneyDTO {
    @JsonAlias("uid")
    private String uid;

    @JsonAlias("from")
    private Long fromAccount;

    @JsonAlias("to")
    private Long toAccount;

    @JsonAlias("amount")
    private BigDecimal amount;
}
