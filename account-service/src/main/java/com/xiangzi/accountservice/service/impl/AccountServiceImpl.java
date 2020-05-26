package com.xiangzi.accountservice.service.impl;

import com.xiangzi.accountservice.entity.Account;
import com.xiangzi.accountservice.repository.AccountDao;
import com.xiangzi.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {

    private static final String ERROR_USER_ID = "1002";

    @Autowired
    private AccountDao accountDao;

    @Transactional
    @Override
    public Boolean debit(String userId, BigDecimal money) {
        Account account = accountDao.findByUserId(userId);
        account.setMoney(account.getMoney().subtract(money));
        accountDao.save(account);
        if (ERROR_USER_ID.endsWith(userId)) {
            throw new RuntimeException("fail");
        }
        System.out.println("还款成功");
        return true;

    }
}
