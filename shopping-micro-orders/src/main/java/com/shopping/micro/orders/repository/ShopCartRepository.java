package com.shopping.micro.orders.repository;

import com.shopping.micro.orders.entity.ShopCart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author ldc
 * @Date 2020/12/15 10:07
 * @Version 1.0
 */
public interface ShopCartRepository extends JpaRepository<ShopCart,Long> {


}
