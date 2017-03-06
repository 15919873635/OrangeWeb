/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.test.classes;

import com.orange.web.type.ServletFileGenerateTemplate;
import com.orange.web.type.TypeFileGenerator;
import com.orange.web.type.bean.TypeFragmentation;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.internal.org.objectweb.asm.Type;

/**
 *
 * @author lining
 */
public class TypeFileGeneratorTesting {
    public static void main(String[] args){
//        System.out.println(Type.getType("Ljava.lang.Object;").getDescriptor());
        TypeFileGenerator fileGenerator = new TypeFileGenerator();
//        TypeFragmentation typeFragmentation = new TypeFragmentation();
        try {
            fileGenerator.generator(ServletFileGenerateTemplate.typeFragmentation, null);
            System.out.println(new String(fileGenerator.getClassWriter().toByteArray()));
            fileGenerator.write2File(fileGenerator.getClassWriter().toByteArray(), "D:\\myhello.class");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
