package com.shopping.micro.orders.entity;

import com.shopping.micro.orders.constants.DaoConstant;
import com.shopping.micro.orders.entity.base.BaseModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Author ldc
 * @Date 2020/12/16 11:54
 * @Version 1.0
 */

@Entity
@Table(name = DaoConstant.FILES_RES_TABLE_NAME)
@Data
public class FilesRes extends BaseModel<FilesRes> {

    @Column(name = DaoConstant.FILE_ID)
    private String fileId;

    @Column(name = DaoConstant.FILE_PATH)
    private String fileResPath;

    @Column(name = DaoConstant.FILE_FORMAT)
    private String fileResFormat;

    @Override
    public Object toDto() {
        return null;
    }
}
