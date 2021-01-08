package com.shopping.micro.orders.dto;

import com.shopping.micro.orders.dto.base.BaseDto;

public class AddressDto extends BaseDto {

    private Long id;

    private String addrUser;

    private String addrMobile;

    private String addrProvince;

    private String addrCity;

    private String addrCounty;

    private String addrDetail;

    //    private User user;
    private Long addrUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddrUser() {
        return addrUser;
    }

    public void setAddrUser(String addrUser) {
        this.addrUser = addrUser;
    }

    public String getAddrMobile() {
        return addrMobile;
    }

    public void setAddrMobile(String addrMobile) {
        this.addrMobile = addrMobile;
    }

    public String getAddrProvince() {
        return addrProvince;
    }

    public void setAddrProvince(String addrProvince) {
        this.addrProvince = addrProvince;
    }

    public String getAddrCity() {
        return addrCity;
    }

    public void setAddrCity(String addrCity) {
        this.addrCity = addrCity;
    }

    public String getAddrCounty() {
        return addrCounty;
    }

    public void setAddrCounty(String addrCounty) {
        this.addrCounty = addrCounty;
    }

    public String getAddrDetail() {
        return addrDetail;
    }

    public void setAddrDetail(String addrDetail) {
        this.addrDetail = addrDetail;
    }

    public Long getAddrUserId() {
        return addrUserId;
    }

    public void setAddrUserId(Long addrUserId) {
        this.addrUserId = addrUserId;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    @Override
    public String toString() {
        return "AddressDto{" +
                "id=" + id +
                ", addrUser='" + addrUser +
                ", addrMobile='" + addrMobile +
                ", addrProvince='" + addrProvince +
                ", addrCity='" + addrCity +
                ", addrCounty='" + addrCounty +
                ", addrDetail='" + addrDetail +
                ", addrUserId='" + addrUserId +
                '}';
    }
}
