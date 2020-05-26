package com.xiangzi.businessservice.service.fallback;

import com.xiangzi.businessservice.feign.AccountFeignClient;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AccountFallback implements AccountFeignClient {
    @Override
    public Boolean debit(String userId, BigDecimal money) {
        System.out.println("补偿。。。");
        return null;
    }
}
