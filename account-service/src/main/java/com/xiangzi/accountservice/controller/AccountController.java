package com.xiangzi.accountservice.controller;

import com.xiangzi.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * 借方
     *
     * @param userId
     * @param money
     * @return
     */
    @GetMapping("/debit")
    public Boolean debit(@RequestParam("userId") String userId, @RequestParam("money") BigDecimal money) {
        System.err.println("积分成功");
        return accountService.debit(userId, money);
    }
}
