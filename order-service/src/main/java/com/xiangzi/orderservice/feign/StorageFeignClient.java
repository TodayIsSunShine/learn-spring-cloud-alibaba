package com.xiangzi.orderservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "storage-service")
public interface StorageFeignClient {


    @GetMapping("/storage/deduct/{commodityCode}/{count}")
    String deduct(@PathVariable("commodityCode") String commodityCode, @PathVariable("count") Integer count);
}
