/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.test.classes;

import com.orange.web.util.ClassGeneratorUtil;

/**
 *
 * @author lining
 */
public class ClassesGeneratorUtilTesting {
    public static void main(String[] args){
        boolean result = ClassGeneratorUtil.methodInClass(MyClassGeneratorDemoClass.class,"getHello"); 
        System.out.println(result);
        boolean result22 = ClassGeneratorUtil.fieldInClass(MyClassGeneratorDemoClass.class,"hello"); 
        System.out.println(result22);
    }
}
