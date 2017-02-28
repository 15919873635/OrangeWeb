/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassWriter;

/**
 * 生成class文件时的UTIL工具类
 * @author lining
 */
public class ClassGeneratorUtil {
    /**
     * 判断一个Public方法方法是否在类
     * @param classz  目标类
     * @param methodName 目标方法名
     * @return 
     */
    public static boolean methodInClass(Class<?> classz , String methodName){
        boolean inObj = false;
        Method[] methods = classz.getMethods();
        if(methods.length > 0){
            for(Method method : methods){
                if(method.getName().equals(methodName)){
                    inObj = true;
                    break;
                }
            }
        }
        return inObj;
    }
    
    /**
     * 判断一个Public字段名称是否在类中
     * @param classz
     * @param fieldName
     * @return 
     */
    public static boolean fieldInClass(Class<?> classz, String fieldName){
        boolean inObj = false;
        Field[] fields = classz.getDeclaredFields();
        if(fields.length > 0){
            for(Field field : fields){
                if(field.getName().equals(fieldName)){
                    inObj = true;
                    break;
                }
            }
        }
        return inObj;
    }
}
