package com.shopping.micro.orders.controller;

import com.shopping.micro.orders.cro.OrderCreateCro;
import com.shopping.micro.orders.cro.OrderPageConditionCro;
import com.shopping.micro.orders.cro.OrderPageCro;
import com.shopping.micro.orders.exception.MyShopException;
import com.shopping.micro.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author ldc
 * @Date 2020/12/10 15:38
 * @Version 1.0
 */

@RestController
@RequestMapping("/service/v1")
public class OrderController extends AbstractBaseCtrl{

    @Autowired
    OrderService orderService;

    @PostMapping("/orders.create")
    public Object createOrders(@RequestBody OrderCreateCro orderCreateCro){
        try{
            return success(orderService.createOrder(orderCreateCro));
        } catch (MyShopException ex){
            return failure(ex.getErrorCode(),ex.getMessage());
        }

    }

    @GetMapping("/order.findById/{id}")
    public Object findOrderById(@PathVariable("id") Long id){
        try{
            return success(orderService.findOrderById(id));
        } catch (MyShopException ex){
            return failure(ex.getErrorCode(),ex.getMessage());
        }
    }

    @PostMapping("/order.findAll")
    public Object findOrdersAll(@RequestBody OrderPageCro orderPageCro){
        return success(getData(orderService.findAllOrders(orderPageCro)));
    }

    @DeleteMapping("order.delete/{id}")
    public Object deleteOrder(@PathVariable("id") Long id){
        try{
            orderService.deleteOrder(id);
            return success("");
        } catch (MyShopException ex){
            return failure(ex.getErrorCode(),ex.getMessage());
        }
    }

    @PostMapping("/order.find.condition")
    public Object findOnCondition(@RequestBody OrderPageConditionCro orderPageConditionCro){
        return success(getData(orderService.findAllWitnCondition(orderPageConditionCro)));
    }

}
