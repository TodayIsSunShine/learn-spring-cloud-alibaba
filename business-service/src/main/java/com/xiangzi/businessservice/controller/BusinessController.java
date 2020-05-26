package com.xiangzi.businessservice.controller;

import com.xiangzi.businessservice.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    /**
     * 调用整体流程、下单、发货、加积分
     *
     * @param userId
     * @param commodityCode
     * @param count
     * @return
     */
    @GetMapping("/purchase")
    public boolean purchase(@RequestParam("userId") String userId,
                            @RequestParam("commodityCode") String commodityCode,
                            @RequestParam("count") int count) {
        return businessService.purchase(userId, commodityCode, count);

    }
}
