package com.shopping.micro.orders.entity;

import com.shopping.micro.orders.constants.DaoConstant;
import com.shopping.micro.orders.dto.GoodsDto;
import com.shopping.micro.orders.entity.base.BaseModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * @Author ldc
 * @Date 2020/12/3 17:20
 * @Version 1.0
 */
@Entity
@Table(name = DaoConstant.GOODS_TABLE_NAME)
@Data
public class Goods extends BaseModel<GoodsDto> {

    @Column(name = DaoConstant.GOODS_NAME)
    private String goodsName;

    @Column(name = DaoConstant.GOODS_PRICE)
    private String goodsPrice;

    @Column(name = DaoConstant.GOODS_INVENTORY_COUNT)
    private String goodsInventoryCount;

    @Column(name = DaoConstant.GOODS_SALES_COUNT)
    private String goodsSalesCount;

    @ElementCollection(targetClass = FilesRes.class)
    private List<FilesRes> goodsTitleImage;

    @Column(name = DaoConstant.GOODS_DETAIL_TEXT)
    private String goodsDetailText;

    @ElementCollection(targetClass = FilesRes.class)
    private List<FilesRes> goodsDetailImage;

    @Column(name = DaoConstant.GOODS_ADD_TIME)
    private String goodsAddTime;

    @Column(name = DaoConstant.GOODS_USER_ID)
    private Long goodsUserId;

//  @transient 就是在给某个javabean上需要添加个属性，但是这个属性你又不希望给存到数据库中去，仅仅是做个临时变量，用一下。
//  不修改已经存在数据库的数据的数据结构

    public Goods(){}

    public Goods(GoodsDto goodsDto){
        this.id = goodsDto.getId();
        this.goodsName = goodsDto.getGoodsName();
        this.goodsPrice = goodsDto.getGoodsPrice();
        this.goodsInventoryCount = goodsDto.getGoodsInventoryCount();
        this.goodsSalesCount = goodsDto.getGoodsSalesCount();
        this.goodsTitleImage = goodsDto.getGoodsTitleImage();
        this.goodsDetailText = goodsDto.getGoodsDetailText();
        this.goodsDetailImage = goodsDto.getGoodsDetailImage();
        this.goodsAddTime = goodsDto.getGoodsAddTime();
    }

    @Override
    public GoodsDto toDto() {
        GoodsDto goodsDto = new GoodsDto();
        goodsDto.setId(id);
        goodsDto.setGoodsName(goodsName);
        goodsDto.setGoodsPrice(goodsPrice);
        goodsDto.setGoodsInventoryCount(goodsInventoryCount);
        goodsDto.setGoodsSalesCount(goodsSalesCount);
        goodsDto.setGoodsTitleImage(goodsTitleImage);
        goodsDto.setGoodsDetailText(goodsDetailText);
        goodsDto.setGoodsDetailImage(goodsDetailImage);
        goodsDto.setGoodsAddTime(goodsAddTime);
        return goodsDto;
    }


}
