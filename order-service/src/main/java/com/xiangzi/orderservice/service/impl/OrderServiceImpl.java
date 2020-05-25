package com.xiangzi.orderservice.service.impl;

import com.xiangzi.orderservice.entity.Order;
import com.xiangzi.orderservice.feign.AccountFeignClient;
import com.xiangzi.orderservice.feign.StorageFeignClient;
import com.xiangzi.orderservice.repository.OrderDao;
import com.xiangzi.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private AccountFeignClient accountFeignClient;
    @Autowired
    private StorageFeignClient storageFeignClient;

    @Transactional
    @Override
    public boolean create(String userId, String commodityCode, int count) {

        BigDecimal orderMoney = new BigDecimal(count).multiply(new BigDecimal(5));

        Order order = new Order();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(count);
        order.setMoney(orderMoney);

        orderDao.save(order);

        storageFeignClient.deduct(commodityCode, count);

        accountFeignClient.debit(userId, orderMoney);

        return true;
    }
}
