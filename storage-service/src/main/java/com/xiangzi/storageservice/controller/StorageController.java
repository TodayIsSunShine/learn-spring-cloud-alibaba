package com.xiangzi.storageservice.controller;

import com.xiangzi.storageservice.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    private StorageService storageService;

    /**
     * 减库存操作
     *
     * @param commodityCode
     * @param count
     * @return
     */
    @GetMapping("/deduct/{commodityCode}/{count}")
    public String deduct(@PathVariable("commodityCode") String commodityCode, @PathVariable("count") int count) {
        return storageService.deduct(commodityCode, count);
    }
}
