package com.shopping.micro.orders.service.impl;

import com.shopping.micro.orders.entity.ShopCart;
import com.shopping.micro.orders.repository.ShopCartRepository;
import com.shopping.micro.orders.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author ldc
 * @Date 2020/12/15 10:08
 * @Version 1.0
 */

@Service
@Transactional
public class ShopCartServiceImpl extends AbstractBaseImpl implements ShopCartService {

    @Autowired
    ShopCartRepository shopCartRepository;

    @Override
    public ShopCart createShopCart(ShopCart shopCart){
        return shopCartRepository.save(shopCart);
    }

}
