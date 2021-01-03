package com.shopping.micro.orders.utils;

/**
 * @Author ldc
 * @Date 2020/12/2 13:56
 * @Version 1.0
 */
public class ThreadLocalUtils {

    private static ThreadLocal<Object> threadLocal = new ThreadLocal<>();

    public static void set(Object object) {
        threadLocal.set(object);
    }

    public static Object get() {
        return threadLocal.get();
    }

    public static void remove() {
        threadLocal.remove();
    }

}
