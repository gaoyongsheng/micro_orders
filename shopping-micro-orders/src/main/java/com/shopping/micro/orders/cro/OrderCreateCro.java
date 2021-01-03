package com.shopping.micro.orders.cro;

import com.shopping.micro.orders.cro.base.BaseCro;

/**
 * @Author ldc
 * @Date 2020/12/10 16:39
 * @Version 1.0
 */
public class OrderCreateCro extends BaseCro {

//    @Autowired
//    GoodsService goodsService;

    private Long goodsId;// 商品id

    private String count;// 购买商品数量

    private String price;// 购买商品的总价格

    private String addressId;// 收货人地址


    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
