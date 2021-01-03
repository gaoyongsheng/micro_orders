package com.shopping.micro.orders.service.impl;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AbstractBaseImpl {
    
    /**
     * @Author ldc
     * @Description //TODO 
     * @Date 16:58 2020/12/7
     * @Param [str]
     * @return java.lang.Long
     */
    public Long strToLong(String str){return Long.parseLong(str);}

    /**
     * 获取pageAble
     * @Param page 页码，当前第几页
     * */
    public Pageable getPageable(int page, int size){
        Pageable pageable = PageRequest.of(page,size);

        return pageable;
    }

    public Pageable getPageable(int page, int size, Sort sort){
        Pageable pageable = PageRequest.of(page,size,sort);

        return pageable;
    }

    /**
     * @Author ldc
     * @Description //TODO 生成当前请求的订单号
     * @Date 14:29 2020/12/14
     * @Param []
     * @return java.lang.String
     */
    public String getCurOrderCode(){
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddHHmmSS");
        return ft.format(dNow);
    }


}
