package com.xiangzi.orderservice.repository;

import com.xiangzi.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order,Long> {
}
