package com.xiangzi.orderservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(name = "account-service")
public interface AccountFeignClient {

    @GetMapping("/account/debit")
    Boolean debit(@RequestParam("userId") String userId, @RequestParam("money") BigDecimal money);

}
