package com.shopping.micro.orders.controller;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.shopping.micro.orders.redis.RedisUtils;
import com.shopping.micro.orders.service.MailService;
import com.shopping.micro.orders.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

public class AbstractBaseCtrl {

    @Autowired
    protected RedisUtils redisUtils;

    @Autowired
    protected MailService mailService;

    /**
     * 返回正确的处理数据
     * */
    public Object success(Object data){
        return ResponseUtils.success(data);
    }

    /**
     * 返回错误的处理数据
     * */
    public Object failure(String code,String msg){ return ResponseUtils.failure(code,msg); }

    /**
     * 利用jpa查询分页结果
     * offset值为-1表示为最后一页，-2表示没有返回数据
     * */
    public Object getData(Page page){
        JSONObject jsonObject = new JSONObject();
        try {
            if(page.getNumberOfElements() != 0){
                jsonObject.put("offset", page.isLast() ? -1 : page.nextPageable().getPageNumber());
                jsonObject.put("dataList",page.getContent());
                jsonObject.put("totalElements",page.getTotalElements());
                jsonObject.put("totalPages",page.getTotalPages());
            }else{
                jsonObject.put("offset", -2);
                jsonObject.put("dataList","");
                jsonObject.put("totalElements",0);
                jsonObject.put("totalPages",0);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }
}
