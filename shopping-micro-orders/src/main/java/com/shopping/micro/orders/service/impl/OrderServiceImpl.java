package com.shopping.micro.orders.service.impl;

import com.shopping.micro.orders.constants.ShopExceptionCode;
import com.shopping.micro.orders.cro.OrderCreateCro;
import com.shopping.micro.orders.cro.OrderPageConditionCro;
import com.shopping.micro.orders.cro.OrderPageCro;
import com.shopping.micro.orders.entity.Order;
import com.shopping.micro.orders.entity.ShopCart;
import com.shopping.micro.orders.exception.MyShopException;
import com.shopping.micro.orders.repository.OrderRepository;
import com.shopping.micro.orders.service.OrderService;
import com.shopping.micro.orders.service.ShopCartService;
import com.shopping.micro.orders.utils.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author ldc
 * @Date 2020/12/10 15:37
 * @Version 1.0
 */

@Service
@Transactional
public class OrderServiceImpl extends AbstractBaseImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

//    @Autowired
//    GoodsService goodsService;

    @Autowired
    ShopCartService shopCartService;

//    @Autowired
//    AddressService addressService;

    @Override
    public Order createOrder(OrderCreateCro orderCreateCro) {
        Order order = new Order();

        ShopCart shopCart = new ShopCart();
        shopCart.setCount(orderCreateCro.getCount());
        shopCart.setTotalPrice(orderCreateCro.getPrice());

//        Set<Goods> goodsList = new HashSet<Goods>();
//        Goods curGoods = goodsService.findGoodsById(orderCreateCro.getGoodsId());
//        goodsList.add(curGoods);
//        shopCart.setGoodsList(goodsList);

        ShopCart temp = shopCartService.createShopCart(shopCart);

        Set<ShopCart> shopCartList = new HashSet<ShopCart>();
        shopCartList.add(temp);
        order.setShopCartList(shopCartList);

        order.setOrderCode(getCurOrderCode());
        order.setOrderAddTime(DateTimeUtils.getSysCurDate());
        order.setOrderTotalPrice(orderCreateCro.getPrice());
        order.setOrderStatus(0+"");

//        User curUser = (User) ThreadLocalUtils.get();
//        order.setUser(curUser);
//
//        Address addr = addressService.findAddressById(strToLong(orderCreateCro.getAddressId()));
//        order.setAddress(addr);

        return orderRepository.save(order);
    }

    @Override
    public Order findOrderById(Long id) {
        Order order = orderRepository.findOrderById(id);
        if(null == order){
            throw new MyShopException(ShopExceptionCode.ENTITY_NO_EXISTS,"订单不存在");
        }
        return orderRepository.findOrderById(id);
    }

    @Override
    public Page<Order> findAllOrders(OrderPageCro orderPageCro) {

        Sort sort = Sort.by("orderAddTime").descending();
        Pageable pageable = getPageable(orderPageCro.getOffset(),orderPageCro.getPageSize(),sort);

        return orderRepository.findAll(pageable);
    }

    @Override
    public void deleteOrder(Long id) {
        findOrderById(id);

        orderRepository.deleteById(id);
    }

    @Override
    public Page<Order> findAllWitnCondition(OrderPageConditionCro orderPageConditionCro) {

        Pageable pageable = getPageable(orderPageConditionCro.getOffset(),orderPageConditionCro.getPageSize());

        Page<Order> orderPage = orderRepository.findAll(new Specification<Order>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> list = new ArrayList<Predicate>();
                // 条件查询订单状态 orderStatus
                if(orderPageConditionCro.getOrderStatus() != ""){
                    Predicate statusP = criteriaBuilder.equal(root.get("orderStatus"),orderPageConditionCro.getOrderStatus());
                    list.add(statusP);
                }
                // 时间范围查询 orderAddTime
                if(orderPageConditionCro.getBeginTime() != "" && orderPageConditionCro.getEndTime() != ""){
                    Predicate timeRange = criteriaBuilder.between(root.get("orderAddTime"),orderPageConditionCro.getBeginTime(),
                            orderPageConditionCro.getEndTime());
                    list.add(timeRange);
                }

                Predicate[] p = new Predicate[list.size()];

                return criteriaBuilder.and(list.toArray(p));
            }
        }, pageable);

        return orderPage;
    }

}
