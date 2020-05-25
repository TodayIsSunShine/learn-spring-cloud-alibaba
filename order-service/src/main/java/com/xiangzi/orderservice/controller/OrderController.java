package com.xiangzi.orderservice.controller;

import com.xiangzi.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private OrderService orderService;


    @GetMapping("/storage/deduct")
    public String storageDeduct(@RequestParam("commodityCode") String commodityCode,
                                @RequestParam("count") int count) {
        return restTemplate.getForObject("http://storage-service/storage/deduct/" + commodityCode + "/" + count, String.class);
    }

    @GetMapping("/create")
    public boolean create(@RequestParam("userId") String userId,
                          @RequestParam("commodityCode") String commodityCode,
                          @RequestParam("count") int count) {
        return orderService.create(userId, commodityCode, count);
    }
}
