package com.shopping.micro.orders.service;

import com.alibaba.fastjson.JSONObject;
import com.shopping.micro.orders.cro.OrderCreateCro;
import com.shopping.micro.orders.cro.OrderPageConditionCro;
import com.shopping.micro.orders.cro.OrderPageCro;
import com.shopping.micro.orders.entity.Order;
import org.springframework.data.domain.Page;

/**
 * @Author ldc
 * @Date 2020/12/10 15:37
 * @Version 1.0
 */
public interface OrderService {

    Order createOrder(OrderCreateCro orderCreateCro);

    Order findOrderById(Long id);

    Page<Order> findAllOrders(OrderPageCro orderPageCro);

    void deleteOrder(Long id);

    Page<Order> findAllWitnCondition(OrderPageConditionCro orderPageConditionCro);

    JSONObject getCurLoginUser(String serviceId);

}
