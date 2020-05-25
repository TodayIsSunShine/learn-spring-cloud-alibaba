package com.xiangzi.businessservice.service.impl;

import com.xiangzi.businessservice.feign.AccountService;
import com.xiangzi.businessservice.feign.OrderService;
import com.xiangzi.businessservice.feign.StorageService;
import com.xiangzi.businessservice.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private OrderService orderService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private StorageService storageService;

    @Override
    public void purchase(String userId, String commodityCode, int orderCount) {
        storageService.deduct(commodityCode, orderCount);

    }
}
