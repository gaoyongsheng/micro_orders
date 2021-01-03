package com.shopping.micro.orders.cro;

import com.shopping.micro.orders.cro.base.BaseCro;
import com.shopping.micro.orders.dto.OrderDto;

/**
 * @Author ldc
 * @Date 2020/12/10 15:24
 * @Version 1.0
 */
public class OrderCro extends BaseCro {

    private Long id;

    private String orderCode;

    private String orderStatus;

    private String orderTotalPrice;

    private String orderUserId;

    private String orderAddTime;

    public OrderDto toDto(){
//        OrderDto orderDto = new OrderDto();
//        orderDto.setId(id);
//        orderDto.setOrderCode(orderCode);
//        orderDto.setOrderStatus(orderStatus);
//        orderDto.setOrderTotalPrice(orderTotalPrice);
//        orderDto.setOrderUserId(orderUserId);
//        orderDto.setOrderAddTime(orderAddTime);
//        return orderDto;
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(String orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public String getOrderUserId() {
        return orderUserId;
    }

    public void setOrderUserId(String orderUserId) {
        this.orderUserId = orderUserId;
    }

    public String getOrderAddTime() {
        return orderAddTime;
    }

    public void setOrderAddTime(String orderAddTime) {
        this.orderAddTime = orderAddTime;
    }
}
