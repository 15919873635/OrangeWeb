/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.util;

/**
 *
 * @author lining
 * 系统加密相关的util工具集合，包括几种基本的加密方式(MD5,SHA)等
 */
public class EncryptUtil {
    public String md5(String targetString){
        return null;
    }
    
    public String md5(byte[] targetBytes){
        String  targetString = new String(targetBytes);
        return md5(targetString);
    }
    
    public String md5(char[] targetCharts){
        String targetString = new String(targetCharts);
        return md5(targetString);
    }
    
    public boolean compareWith(String originalStr,String targetStr){
        return md5(originalStr).equals(targetStr);
    }
    
    public boolean compareWith(byte[] originalBytes,String targetStr){
        return md5(originalBytes).equals(targetStr);
    }
    
    public boolean compareWith(char[] originalChars,String targetStr){
        return md5(originalChars).equals(targetStr);
    }
}
