package com.shopping.micro.orders.dto;

import com.shopping.micro.orders.dto.base.BaseDto;
import com.shopping.micro.orders.entity.FilesRes;

import java.util.List;

/**
 * @Author ldc
 * @Date 2020/12/7 15:36
 * @Version 1.0
 */
public class GoodsDto extends BaseDto {

    private Long id;

    private String goodsName;

    private String goodsPrice;

    private String goodsInventoryCount;

    private String goodsSalesCount;

    private List<FilesRes> goodsTitleImage;

    private String goodsDetailText;

    private String goodsAddTime;

    private List<FilesRes> goodsDetailImage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsInventoryCount() {
        return goodsInventoryCount;
    }

    public void setGoodsInventoryCount(String goodsInventoryCount) {
        this.goodsInventoryCount = goodsInventoryCount;
    }

    public String getGoodsSalesCount() {
        return goodsSalesCount;
    }

    public void setGoodsSalesCount(String goodsSalesCount) {
        this.goodsSalesCount = goodsSalesCount;
    }

    public List<FilesRes> getGoodsTitleImage() {
        return goodsTitleImage;
    }

    public void setGoodsTitleImage(List<FilesRes> goodsTitleImage) {
        this.goodsTitleImage = goodsTitleImage;
    }

    public String getGoodsDetailText() {
        return goodsDetailText;
    }

    public void setGoodsDetailText(String goodsDetailText) {
        this.goodsDetailText = goodsDetailText;
    }

    public String getGoodsAddTime() {
        return goodsAddTime;
    }

    public void setGoodsAddTime(String goodsAddTime) {
        this.goodsAddTime = goodsAddTime;
    }

    public List<FilesRes> getGoodsDetailImage() {
        return goodsDetailImage;
    }

    public void setGoodsDetailImage(List<FilesRes> goodsDetailImage) {
        this.goodsDetailImage = goodsDetailImage;
    }

    @Override
    public String toString() {
        return "GoodsDto{" +
                "id='" + id +
                ", goodsName='" + goodsName +
                ", goodsPrice='" + goodsPrice +
                ", goodsInventoryCount='" + goodsInventoryCount +
                ", goodsSalesCount='" + goodsSalesCount +
                ", goodsTitleImage=" + goodsTitleImage +
                ", goodsDetailText='" + goodsDetailText +
                ", goodsDetailImage=" + goodsDetailImage +
                ", goodsAddTime=" + goodsAddTime +
                '}';
    }
}
