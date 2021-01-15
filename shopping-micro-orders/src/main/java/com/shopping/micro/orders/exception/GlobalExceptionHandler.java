package com.shopping.micro.orders.exception;

import com.alibaba.fastjson.JSONObject;
import com.shopping.micro.orders.utils.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

/**
 * @Author ldc
 * @Date 2021/1/12 16:52
 * @Version 1.0
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 1、处理自定义的业务异常
     * @param
     * @param e
     * @return
     */
    @ExceptionHandler(value = MyShopException.class)
    @ResponseBody
    public JSONObject myExceptionHandler(MyShopException e) {
        logger.info("********GlobalExceptionHandler********", e.getMessage());
        return ResponseUtils.failure(e.getErrorCode(), e.getMessage());

    }

    /**
     * 2、处理其他异常
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public JSONObject exceptionHandler(Exception e){

        if (e instanceof NullPointerException) {
            logger.info("********GlobalExceptionHandler********" + e.getMessage(), e);
            return ResponseUtils.failure("999999","发生空指针异常");
        } else if (e instanceof IllegalArgumentException) {
            logger.info("********GlobalExceptionHandler********" + e.getMessage(), e);
            return ResponseUtils.failure("999999","请求参数类型不匹配");
        } else if (e instanceof SQLException) {
            logger.info("********GlobalExceptionHandler********" + e.getMessage(), e);
            return ResponseUtils.failure("999999","数据库访问异常");
        } else {
            logger.info("********GlobalExceptionHandler********" + e.getMessage(), e);
            return ResponseUtils.failure("999999","服务器代码发生异常,请联系管理员");
        }
    }

}
