package com.shopping.micro.orders.entity;

import com.shopping.micro.orders.constants.DaoConstant;
import com.shopping.micro.orders.entity.base.BaseModel;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author ldc
 * @Date 2020/12/14 16:29
 * @Version 1.0
 */

@Entity
@Table(name = DaoConstant.SHOP_CART_TABLE_NAME)
@Data
public class ShopCart extends BaseModel<ShopCart> {

    @Column(name = DaoConstant.SHOP_CART_COUNT)
    private String count;

    @Column(name = DaoConstant.SHOP_CART_TOTAL_PRICE)
    private String totalPrice;

    @ManyToMany(cascade={CascadeType.REFRESH,CascadeType.MERGE},fetch = FetchType.LAZY)
    @JoinTable(name = DaoConstant.MIDDLE_SHOP_CART_GOODS_TABLE_NAME,
               joinColumns = {@JoinColumn(name = DaoConstant.MIDDLE_SHOP_CART_ID)}, //本表在中间表的外键名称
               inverseJoinColumns = {@JoinColumn(name = DaoConstant.MIDDLE_GOODS_ID)})//另一个表在中间表的外键名称,如果不注明外键名，则默认用关联的表名作为外键名
    private Set<Goods> goodsList = new HashSet<Goods>();

    @Override
    public Object toDto() {
        return null;
    }

}
