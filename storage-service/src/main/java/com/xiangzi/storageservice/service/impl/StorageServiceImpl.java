package com.xiangzi.storageservice.service.impl;

import com.xiangzi.storageservice.entity.Storage;
import com.xiangzi.storageservice.repository.StorageDao;
import com.xiangzi.storageservice.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageDao storageDao;

    @Override
    public String deduct(String commodityCode, int count) {
        Storage storage = new Storage();
        storage.setCommodityCode(commodityCode);
        storage.setCount(count);
        storageDao.save(storage);
        System.out.println("库存扣减成功");
        return "deduct success";
    }
}
