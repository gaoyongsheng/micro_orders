package com.shopping.micro.orders.configuration.interceptor;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shopping.micro.orders.constants.ShopExceptionCode;
import com.shopping.micro.orders.entity.User;
import com.shopping.micro.orders.exception.MyShopException;
import com.shopping.micro.orders.service.OrderService;
import com.shopping.micro.orders.utils.EncryptUtils;
import com.shopping.micro.orders.utils.ResponseUtils;
import com.shopping.micro.orders.utils.ThreadLocalUtils;
import com.shopping.micro.orders.utils.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.attribute.UserDefinedFileAttributeView;

public class MyInterceptor implements HandlerInterceptor {

    private static final Logger LOG = LoggerFactory.getLogger(MyInterceptor.class);

    @Autowired
    OrderService orderService;

    /*{
        content-type:application/json,
        serviceId:username,
        signInfo: sha5加密(username + password(MD5加密转大写) + ts)
        ts:当前请求的时间戳（毫秒）
    }*/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        try {

            String serviceId = request.getHeader("serviceId").trim();
            String signInfo = request.getHeader("signInfo").trim();
            String ts = request.getHeader("ts").trim();
            String reqBody = Util.getReqBodyStrByHeader(request);

            LOG.info("************serviceId************[{}]",serviceId);
            LOG.info("************signInfo*************[{}]",signInfo);
            LOG.info("************reqBody**************[{}]",reqBody);

//          校验签名是否正确
            JSONObject result = orderService.getCurLoginUser(serviceId);
            User curUser = JSON.toJavaObject(result.getJSONObject("data"), User.class);

            LOG.info("************curLoginUser*********[{}]",curUser.toString());

            String signStr = serviceId + curUser.getPassword() + ts;
            if(signInfo.equals(EncryptUtils.shaEncode(signStr))){
                ThreadLocalUtils.set(curUser);
                return true;
            } else {
                throw new MyShopException(ShopExceptionCode.SIGNATURE_ERROR,"签名错误");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
            ResponseUtils.failure(ShopExceptionCode.SIGNATURE_ERROR,"签名错误");
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LOG.info("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LOG.info("afterCompletion");
    }

}
