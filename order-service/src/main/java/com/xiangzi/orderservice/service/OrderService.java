package com.xiangzi.orderservice.service;

public interface OrderService {

    public boolean create(String userId,String commodityCode,int count);
}
