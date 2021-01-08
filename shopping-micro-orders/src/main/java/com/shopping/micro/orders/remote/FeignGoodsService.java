package com.shopping.micro.orders.remote;

import com.alibaba.fastjson.JSONObject;
import com.shopping.micro.orders.configuration.feign.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author ldc
 * @Date 2021/1/7 15:59
 * @Version 1.0
 */

@Component
@FeignClient(name = "shopping-micro-goods", configuration= FeignConfiguration.class)
public interface FeignGoodsService {

    @ResponseBody
    @GetMapping(value="service/v1/goods.findById/{id}")
    public JSONObject findGoodsById(@PathVariable("id") Long id);

}
