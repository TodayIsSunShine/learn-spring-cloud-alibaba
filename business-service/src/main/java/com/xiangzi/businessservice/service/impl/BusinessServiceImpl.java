package com.xiangzi.businessservice.service.impl;

import com.xiangzi.businessservice.feign.AccountFeignClient;
import com.xiangzi.businessservice.feign.OrderFeignClient;
import com.xiangzi.businessservice.feign.StorageFeignClient;
import com.xiangzi.businessservice.service.BusinessService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private OrderFeignClient orderFeignClient;
    @Autowired
    private AccountFeignClient accountFeignClient;
    @Autowired
    private StorageFeignClient storageFeignClient;

    @GlobalTransactional
    @Override
    public boolean purchase(String userId, String commodityCode, int orderCount) {
        orderFeignClient.create(userId, commodityCode, orderCount);
        System.out.println("----下单成功---");
        accountFeignClient.debit(userId, new BigDecimal(5));
        System.out.println("---余额扣减成功---");
        storageFeignClient.deduct(commodityCode, orderCount);
        System.out.println("---库存扣减成功11---");
        return true;
    }
}
