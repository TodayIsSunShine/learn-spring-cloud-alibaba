package com.xiangzi.businessservice.service;

public interface BusinessService {

    boolean purchase(String userId, String commodityCode, int orderCount);

}
