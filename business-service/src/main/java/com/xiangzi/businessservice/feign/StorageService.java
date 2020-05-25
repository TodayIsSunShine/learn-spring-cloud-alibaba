package com.xiangzi.businessservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "storage-service")
public interface StorageService {


    @GetMapping(value = "/storage/deduct/{commodityCode}/{count}")
    String deduct(@PathVariable("commodityCode") String commodityCode, @PathVariable("count") int count);
}
