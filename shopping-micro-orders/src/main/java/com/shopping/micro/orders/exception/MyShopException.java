package com.shopping.micro.orders.exception;

public class MyShopException extends RuntimeException {

    private String errorCode;

    public MyShopException(String errorCode){this.errorCode = errorCode;}

    public MyShopException(String errorCode,String errorMsg){
        super(errorMsg);
        this.errorCode = errorCode;
    }

    public String getErrorCode(){return this.errorCode;}
}
