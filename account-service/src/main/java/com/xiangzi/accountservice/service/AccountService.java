package com.xiangzi.accountservice.service;

import java.math.BigDecimal;

public interface AccountService {

    Boolean debit(String userId, BigDecimal money);
}
