package com.shopping.micro.orders.entity.base;

import java.io.Serializable;

public interface ToDto<T> extends Serializable {
    T toDto();
}
