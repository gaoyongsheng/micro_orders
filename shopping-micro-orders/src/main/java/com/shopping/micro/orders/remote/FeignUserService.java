package com.shopping.micro.orders.remote;

import com.alibaba.fastjson.JSONObject;
import com.shopping.micro.orders.configuration.feign.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author ldc
 * @Date 2021/1/5 15:43
 * @Version 1.0
 */
//name：远程服务名，及spring.application.name配置的名称
//此类中的方法和远程服务中contoller中的方法名和参数需保持一致

@Component
@FeignClient(name = "shopping-micro-user", configuration= FeignConfiguration.class)
public interface FeignUserService {

    @ResponseBody
    @RequestMapping(value = "service/v1/user.findByUserNameOrMobile/{str}")
    public JSONObject findUserByUserNameOrMobile(@PathVariable("str") String str);

    @ResponseBody
    @GetMapping("service/v1/address.findAllByAddressId/{addrId}")
    public JSONObject findAddressByAddrId(@PathVariable("addrId") Long addrId);

}
