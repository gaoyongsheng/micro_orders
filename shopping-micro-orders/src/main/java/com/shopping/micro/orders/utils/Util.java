package com.shopping.micro.orders.utils;

import com.shopping.micro.orders.configuration.filter.MyRequestWrapper;
import com.shopping.micro.orders.constants.CommomData;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author Gao
 * @Date 2020/11/22 16:39
 * @Version 1.0
 */
public class Util {

    /**
     * 校验当前字符串是不是手机号
     * */
    public static Boolean checkIsPhone(String phone){
        if (phone.matches(CommomData.REGEX_MOBILE)) {
            return true; // 是手机号
        } else {
            return false;
        }
//        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
//        if (phone.length() != 11) {
//            return false;
//        } else {
//            Pattern p = Pattern.compile(regex);
//            Matcher m = p.matcher(phone);
//            boolean isMatch = m.matches();
//            if (isMatch) {
//                return true;
//            } else {
//                return false;
//            }
//        }
    }

    /**
     * 获取请求体的字符串
     * */
    public static String getReqBodyStrByHeader(HttpServletRequest request) throws IOException {

        MyRequestWrapper myRequestWrapper = new MyRequestWrapper(request);
        return myRequestWrapper.getBody();

//        StringBuffer strBuffer = new StringBuffer();
//        try {
//            BufferedReader bufferedReader = request.getReader();
//            String str = null;
//            while((str = bufferedReader.readLine()) != null){
//                strBuffer.append(str.trim());
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return strBuffer.toString();
    }
}
