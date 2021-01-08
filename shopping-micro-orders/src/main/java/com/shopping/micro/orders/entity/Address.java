package com.shopping.micro.orders.entity;


import com.shopping.micro.orders.constants.DaoConstant;
import com.shopping.micro.orders.dto.AddressDto;
import com.shopping.micro.orders.entity.base.BaseModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = DaoConstant.ADDRESS_TABLE_NAME)
@Data
public class Address extends BaseModel<AddressDto> {

    @Column(name = DaoConstant.ADDRESS_NAME)
    private String addrUser;

    @Column(name = DaoConstant.ADDRESS_MOBILE)
    private String addrMobile;

    @Column(name = DaoConstant.ADDRESS_PROVINCE)
    private String addrProvince;

    @Column(name = DaoConstant.ADDRESS_CITY)
    private String addrCity;

    @Column(name = DaoConstant.ADDRESS_COUNTY)
    private String addrCounty;

    @Column(name = DaoConstant.ADDRESS_DETAIL)
    private String addrDetail;
//    mappedBy标签一定是定义在被拥有方的（被控方），他指向拥有方，表示此表是关系中的从表，mappedBy = "idCard"，值是主表中的属性
//    @ManyToOne(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
//    @JoinColumn(name = DaoConstant.ADDRESS_USER_ID)
//    private User user;

    @Column(name = DaoConstant.ADDRESS_USER_ID)
    private Long addrUserId;

    public Address(){}

    public Address(AddressDto addressDto){
        this.id = addressDto.getId();
        this.addrUser = addressDto.getAddrUser();
        this.addrMobile = addressDto.getAddrMobile();
        this.addrProvince = addressDto.getAddrProvince();
        this.addrCity = addressDto.getAddrCity();
        this.addrCounty = addressDto.getAddrCounty();
        this.addrDetail = addressDto.getAddrDetail();
        this.addrUserId = addressDto.getAddrUserId();
    }

    @Override
    public AddressDto toDto() {
        AddressDto addressDto = new AddressDto();
        addressDto.setId(id);
        addressDto.setAddrUser(addrUser);
        addressDto.setAddrMobile(addrMobile);
        addressDto.setAddrProvince(addrProvince);
        addressDto.setAddrCity(addrCity);
        addressDto.setAddrCounty(addrCounty);
        addressDto.setAddrDetail(addrDetail);
        return addressDto;
    }


    @Override
    public String toString() {
        return "Address{" +
                "id='" + id +
                ",addrUser='" + addrUser +
                ", addrMobile='" + addrMobile +
                ", addrProvince='" + addrProvince +
                ", addrCity='" + addrCity +
                ", addrCounty='" + addrCounty +
                ", addrDetail='" + addrDetail +
                ", addrUserId='" + addrUserId +
                '}';
    }
}
