package com.shopping.micro.orders.dto;

import com.shopping.micro.orders.dto.base.BaseDto;

/**
 * @Author Gao
 * @Date 2020/11/22 23:31
 * @Version 1.0
 */
public class UserDto extends BaseDto {

    private Long id;

    private String userName;

    private String trueName;

    private String password;

    private String email;

    private String mobileNum;

    private String avatarAddress;

    private String sex;

    private String addTime;

    private String userRole;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getAvatarAddress() {
        return avatarAddress;
    }

    public void setAvatarAddress(String avatarAddress) {
        this.avatarAddress = avatarAddress;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "UserDto [" +
                "id=" + id +
                ", userName='" + userName +
                ", trueName='" + trueName +
                ", password='" + password +
                ", email='" + email +
                ", mobileNum='" + mobileNum +
                ", avatarAddress='" + avatarAddress +
                ", sex='" + sex +
                ", addTime='" + addTime +
                ", userRole='" + userRole +
                ']';
    }
}
