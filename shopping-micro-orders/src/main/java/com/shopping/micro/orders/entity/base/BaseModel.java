package com.shopping.micro.orders.entity.base;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseModel<T> implements ToDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
