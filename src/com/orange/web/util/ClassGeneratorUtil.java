/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import jdk.internal.org.objectweb.asm.Opcodes;
import jdk.internal.org.objectweb.asm.Type;

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
    /**
     * 根据类型名获取asm的类型名
     * @param name
     * @return
     * @throws ClassNotFoundException 
     */
    public static String getTypeDescriptor(String name) throws ClassNotFoundException{
        String descriptor = null;
        if(name != null && name.length() > 0){
            switch(name){
                case "java.lang.Integer" :
                    descriptor = Type.INT_TYPE.getDescriptor();
                    break;
                case "java.lang.Long" : 
                    descriptor = Type.LONG_TYPE.getDescriptor();
                    break;
                case "java.lang.Float" : 
                    descriptor = Type.FLOAT_TYPE.getDescriptor();
                    break;      
                case "java.lang.Double" : 
                    descriptor = Type.DOUBLE_TYPE.getDescriptor();
                    break;
                case "java.lang.Short" : 
                    descriptor = Type.SHORT_TYPE.getDescriptor();
                    break;
                case "java.lang.Boolean" : 
                    descriptor = Type.BOOLEAN_TYPE.getDescriptor();
                    break;  
                case "java.lang.Byte" : 
                    descriptor = Type.BYTE_TYPE.getDescriptor();
                    break;     
                case "java.lang.Chart" : 
                    descriptor = Type.CHAR_TYPE.getDescriptor();
                    break;  
                default :
                    Class<?> classzz = Class.forName(name);
                    descriptor = "L"+classzz.getName()+";";
                    break;
            }
        }
        return descriptor;
    }
    /**
     * 将带有.好的包名转换为/的包名
     * @param namespace
     * @return 
     */
    public static String transform2PackageName(String namespace){
        return namespace.replaceAll("[.]", "/");
    }
}
