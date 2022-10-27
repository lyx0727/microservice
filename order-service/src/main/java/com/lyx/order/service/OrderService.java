package com.lyx.order.service;

import com.lyx.feign.clients.UserClient;
import com.lyx.feign.pojo.User;
import com.lyx.order.mapper.OrderMapper;
import com.lyx.order.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderMapper orderMapper;
    private final UserClient userClient;

    @Autowired
    public OrderService(OrderMapper orderMapper, UserClient userClient) {
        this.orderMapper = orderMapper;
        this.userClient = userClient;
    }

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // 2.用Feign远程调用
        User user = userClient.findById(order.getUserId());
        // 3.封装user到Order
        order.setUser(user);
        // 4.返回
        return order;
    }
}
