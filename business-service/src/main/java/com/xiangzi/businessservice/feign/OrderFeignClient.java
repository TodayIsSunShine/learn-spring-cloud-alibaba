package com.xiangzi.businessservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "order-service")
public interface OrderFeignClient {

    @GetMapping("/order/create")
    boolean create(@RequestParam("userId") String userId,
                   @RequestParam("commodityCode") String commodityCode,
                   @RequestParam("count") int count);
}
