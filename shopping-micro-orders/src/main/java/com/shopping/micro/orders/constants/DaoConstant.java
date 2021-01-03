package com.shopping.micro.orders.constants;

import java.util.List;

/**
 * 数据库字段常量.
 */
public class DaoConstant {

    /**
     * 用户表(user)
     */
    public static final String USER_TABLE_NAME = "user";
    public static final String USER_ID = "id";
    public static final String USER_USERNAME = "user_name";//用户名
    public static final String USER_PASSWORD = "password";//密码
    public static final String USER_EMAIL = "email";//邮箱
    public static final String USER_MOBILE_NUM = "mobile_num";//手机号
    public static final String USER_TRUE_NAME = "true_name";//真实姓名
    public static final String USER_AVATAR_ADDR = "avatar_address";//用户头像地址
    public static final String USER_SEX = "sex";//性别  1：男   0：女
    public static final String USER_ADD_TIME = "add_time";//创建日期
    public static final String USER_ROLE = "user_role";//用户角色，卖家:seller,买家：buyer

    /**
     * 地址表（address）
     */
    public static final String ADDRESS_TABLE_NAME = "address";
    public static final String ADDRESS_ID = "id";
    public static final String ADDRESS_NAME = "addr_user"; //收件人名称
    public static final String ADDRESS_MOBILE = "addr_mobile";//收件人手机号
    public static final String ADDRESS_PROVINCE = "addr_province";//收件人所在省
    public static final String ADDRESS_CITY = "addr_city";//收件人所在市
    public static final String ADDRESS_COUNTY = "addr_county";//收件人所在县、区
    public static final String ADDRESS_DETAIL = "addr_detail";//收件人所在的详细地址
    public static final String ADDRESS_USER_ID = "addr_user_id";//address表的外键指向用户表的主键


    /**
     * 商品表（goods）
     */
    public static final String GOODS_TABLE_NAME = "goods";//表名
    public static final String GOODS_ID = "id";//商品id
    public static final String GOODS_NAME = "goods_name";//商品名称
    public static final String GOODS_PRICE = "goods_price";//商品价格
    public static final String GOODS_INVENTORY_COUNT = "goods_inventory_count";//商品当前库存量
    public static final String GOODS_SALES_COUNT = "goods_sales_count";//商品销量
    public static final String GOODS_TITLE_IMAGE = "goods_title_image";//商品图片集合
    public static final String GOODS_DETAIL_TEXT = "goods_detail_text";//商品详情描述文本
    public static final String GOODS_DETAIL_IMAGE = "goods_detail_image";//商品详情图片集合
    public static final String GOODS_ADD_TIME = "goods_add_time";//商品添加时间
    public static final String GOODS_USER_ID = "goods_user_id";//goods表的外键指向用户表的主键


    /**
     * 购物车表（shop_cart）
     */
    public static final String SHOP_CART_TABLE_NAME = "shop_cart";//表名
    public static final String SHOP_CART_ID = "id";
    public static final String SHOP_CART_COUNT = "count";//购买的商品数量
    public static final String SHOP_CART_TOTAL_PRICE = "total_price";//购买的商品总价格

    /**
     * 购物车表和商品表的中间表（middle_shop_cart_goods）
     */
    public static final String MIDDLE_SHOP_CART_GOODS_TABLE_NAME = "middle_shop_cart_goods";//表名
    public static final String MIDDLE_SHOP_CART_ID = "middle_shop_cart_id";//购物车id
    public static final String MIDDLE_GOODS_ID = "middle_goods_id";//购买的商品id

    /**
     * 订单表（orderS）
     */
    public static final String ORDERS_TABLE_NAME = "orders";//表名
    public static final String ORDERS_ID = "id";//订单id
    public static final String ORDERS_CODE  = "order_code";//订单编号
    public static final String ORDERS_STATUS = "order_status";//订单状态 0 待付款 1 待发货 2 待收货 3 完成
    public static final String ORDERS_TOTAL_PRICE = "order_total_price";//订单总价
    public static final String ORDERS_ADD_TIME = "order_add_time";//订单生成时间
    public static final String ORDERS_USER_ID = "order_user_id";//下订单的用户的id
    public static final String ORDERS_ADDRESS_ID = "order_address_id";//下订单的用户的id
    public static final String ORDERS_SHOP_CART_ID = "order_shop_cart_id";//订单关联的购物车表的Id(外键)

    /**
     * 图片资源表表（files_res）
     */
    public static final String FILES_RES_TABLE_NAME = "files_res";//表名
    public static final String FILES_RES_ID = "id";//主键id
    public static final String FILE_ID = "file_id";// fastdfs返回的值
    public static final String FILE_PATH = "file_res_path";
    public static final String FILE_FORMAT = "file_res_format"; // 图片格式 .png .jpg


    /**
     * 操作日志表(oper_log)
     */
    public static final String OPER_LOG_TABLE_NAME = "oper_log";
    public static final String OPER_LOG_USER_ID = "user_id"; //用户ID
    public static final String OPER_LOG_USERNAME = "username"; //用户名
    public static final String OPER_LOG_TRUE_NAME = "trueName"; //用户名称
    public static final String OPER_LOG_MOBILE_NUM = "mobile_num"; //手机号
    public static final String OPER_LOG_API_INTERFACE = "api_interface"; //API接口
    public static final String OPER_LOG_API_DESCRIPTION = "api_description"; //API描述
    public static final String OPER_LOG_REQ_DATA = "req_data"; //请求数据
    public static final String OPER_LOG_RET_CODE = "ret_code"; //返回结果吗
    public static final String OPER_LOG_REQ_TIME = "req_time"; //请求时间


    /***
     * 头像  http://img13.360buyimg.com/n1/jfs/t1/120779/36/13461/117573/5f6c6589Edadbe6d0/2c47e836ae440048.jpg
     * 商品  洋河52度尊享版
     * 价格  429.00
     * 描述  洋河 梦之蓝 M1·精装尊享版 单盒装 500ml 52度口感绵柔浓香型高度白酒 送礼佳选
     * 详情图片 http://img30.360buyimg.com/sku/jfs/t1/152076/32/689/66024/5f6c66a7E4a5de59f/98e5d0dc824f85f6.jpg
     *         http://img30.360buyimg.com/sku/jfs/t1/145186/36/9192/132434/5f6c66a7E756d01e2/7f909ff59b9c315d.jpg
     *         http://img30.360buyimg.com/sku/jfs/t1/122186/8/13351/70750/5f6c66a7E4b9be84f/aaa242ba0fe8be44.jpg
     *         http://img30.360buyimg.com/sku/jfs/t1/139838/24/9035/77538/5f6c66a7Ec16608c8/773afa6b8094e002.jpg
     */


}
