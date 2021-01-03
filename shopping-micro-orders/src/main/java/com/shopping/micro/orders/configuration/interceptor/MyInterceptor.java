package com.shopping.micro.orders.configuration.interceptor;


import com.shopping.micro.orders.constants.ShopExceptionCode;
import com.shopping.micro.orders.utils.ResponseUtils;
import com.shopping.micro.orders.utils.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyInterceptor implements HandlerInterceptor {

    private static final Logger LOG = LoggerFactory.getLogger(MyInterceptor.class);

//    @Autowired
//    private UserService userService;

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
//            User curUser = userService.findCurUserByUserNameOrMobile(serviceId);
//
//            LOG.info("************curLoginUser*********[{}]",curUser.toString());
//
//            String signStr = serviceId + curUser.getPassword() + ts;
//            if(signInfo.equals(EncryptUtils.shaEncode(signStr))){
//                ThreadLocalUtils.set(curUser);
                return true;
//            } else {
//                throw new MyShopException(ShopExceptionCode.SIGNATURE_ERROR,"签名错误");
//            }

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
