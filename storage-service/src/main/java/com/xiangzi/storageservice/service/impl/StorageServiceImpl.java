package com.xiangzi.storageservice.service.impl;

import com.xiangzi.storageservice.service.StorageService;
import org.springframework.stereotype.Service;

@Service
public class StorageServiceImpl implements StorageService {
    @Override
    public String deduct(String commodityCode, int count) {
        System.out.println("库存扣减成功");
        return "deduct success";
    }
}
