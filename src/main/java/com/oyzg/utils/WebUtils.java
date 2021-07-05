package com.oyzg.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class WebUtils {

    public  static <T> T copyParamToBean(Map value, T bean) {

        try {
            System.out.println("注入之前：" + bean);
            //把所有请求的参数都注入到user对象中
            BeanUtils.populate(bean,value);
            System.out.println("注入之后：" + bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将字符串转换为int类型的数据
     * @param strInt
     * @param dafaultValue
     * @return
     */
    public static Integer parseInt(String strInt, int dafaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return dafaultValue;
    }
}
