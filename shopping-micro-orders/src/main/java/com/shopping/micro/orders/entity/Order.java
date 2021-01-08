package com.shopping.micro.orders.entity;

import com.shopping.micro.orders.constants.DaoConstant;
import com.shopping.micro.orders.dto.OrderDto;
import com.shopping.micro.orders.entity.base.BaseModel;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author ldc
 * @Date 2020/12/10 10:08
 * @Version 1.0
 */

@Entity
@Table(name = DaoConstant.ORDERS_TABLE_NAME)
@Data
public class Order extends BaseModel<OrderDto> {

    @Column(name = DaoConstant.ORDERS_CODE)
    private String orderCode;

    @Column(name = DaoConstant.ORDERS_STATUS)
    private String orderStatus;

    @Column(name = DaoConstant.ORDERS_TOTAL_PRICE)
    private String orderTotalPrice;

    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinColumn(name = DaoConstant.ORDERS_USER_ID)
    private User user;

    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinColumn(name = DaoConstant.ORDERS_ADDRESS_ID)
    private Address address;

    @Column(name = DaoConstant.ORDERS_ADD_TIME)
    private String orderAddTime;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = DaoConstant.ORDERS_SHOP_CART_ID)
    private Set<ShopCart> shopCartList = new HashSet<ShopCart>();

    public Order(){}

    public Order(OrderDto orderDto){
        this.orderCode = orderDto.getOrderCode();
        this.orderStatus = orderDto.getOrderStatus();
        this.orderTotalPrice = orderDto.getOrderTotalPrice();
        this.orderAddTime = orderDto.getOrderAddTime();
    }



    @Override
    public OrderDto toDto() {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(id);
        orderDto.setOrderCode(orderCode);
        orderDto.setOrderStatus(orderStatus);
        orderDto.setOrderTotalPrice(orderTotalPrice);
        orderDto.setOrderAddTime(orderAddTime);
        return null;
    }
}
