/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.util;

/**
 *
 * @author lining
 */
public class StringUtil {
    public static boolean isEmpty(String targetStr){
        boolean result = false;
        if(targetStr == null || targetStr.trim().equals(""))
            result =  true;
        return result;
    }
    
    /**
     * 判断是否是数值类型的字符串
     * @param targetStr
     * @return 
     */
    public static boolean isNumbic(String targetStr){
        return targetStr.matches("^[0-9]+(.[0-9]*)?$");
    }
}
