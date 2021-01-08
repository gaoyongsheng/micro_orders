package com.shopping.micro.orders.entity;


import com.shopping.micro.orders.constants.DaoConstant;
import com.shopping.micro.orders.dto.UserDto;
import com.shopping.micro.orders.entity.base.BaseModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Author Gao
 * @Date 2020/10/21 22:55
 * @Version 1.0
 */

@Entity
@Table(name = DaoConstant.USER_TABLE_NAME)
@Data
public class User extends BaseModel<UserDto> {

    @Column(name = DaoConstant.USER_USERNAME)
    private String userName;

    @Column(name = DaoConstant.USER_TRUE_NAME)
    private String trueName;

    @Column(name = DaoConstant.USER_PASSWORD)
    private String password;

    @Column(name = DaoConstant.USER_EMAIL)
    private String email;

    @Column(name = DaoConstant.USER_MOBILE_NUM)
    private String mobileNum;

    @Column(name = DaoConstant.USER_AVATAR_ADDR)
    private String avatarAddress;

    @Column(name = DaoConstant.USER_SEX)
    private String sex;

    @Column(name = DaoConstant.USER_ADD_TIME)
    private String addTime;

    @Column(name = DaoConstant.USER_ROLE)
    private String userRole;


    public User(){}

    public User(UserDto userDto){
        this.id = userDto.getId();
        this.userName = userDto.getUserName();
        this.trueName = userDto.getTrueName();
        this.password = userDto.getPassword();
        this.email = userDto.getEmail();
        this.mobileNum = userDto.getMobileNum();
        this.avatarAddress = userDto.getAvatarAddress();
        this.sex = userDto.getSex();
        this.addTime = userDto.getAddTime();
        this.userRole = userDto.getUserRole();

    }


    @Override
    public UserDto toDto() {
        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setUserName(userName);
        userDto.setTrueName(trueName);
        userDto.setPassword(password);
        userDto.setMobileNum(mobileNum);
        userDto.setAddTime(addTime);
        userDto.setAvatarAddress(avatarAddress);
        userDto.setEmail(email);
        userDto.setSex(sex);
        userDto.setUserRole(userRole);
        return userDto;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id +
                ",userName='" + userName +
                ", trueName='" + trueName +
                ", password='" + password +
                ", email='" + email +
                ", mobileNum='" + mobileNum +
                ", avatarAddress='" + avatarAddress +
                ", sex='" + sex +
                ", addTime='" + addTime +
                ", userRole='" + userRole +
                '}';
    }


}
