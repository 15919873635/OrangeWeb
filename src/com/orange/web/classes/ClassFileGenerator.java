/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.classes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * class文件生成器
 * @author lining
 */
public class ClassFileGenerator implements ClassGenerator{

    @Override
    public void generator(ClassReader classReader, ClassWriter classWriter) {
        
    }
    /**
     * 将生成的class字节数据写入到class文件中
     * @param bytes
     * @param filePath
     * @throws IOException 
     */
    public void write2File(byte[] bytes,String filePath) throws IOException{
        File file = new File(filePath);
        if(file.exists())
            file.delete();
        boolean succ = file.createNewFile();
        if(succ){
            FileOutputStream fileOut = new FileOutputStream(file);
            fileOut.write(bytes);
            fileOut.close();
        }
    }
    /**
     * 将生成的class数据写入到class文件中
     * @param data
     * @param filePath
     * @throws IOException 
     */
    public void write2File(String data,String filePath) throws IOException{
        byte[] bytes = data.getBytes();
        write2File(bytes,filePath);
    }
    
    /**
     * 生成类的头部信息数据
     * @param classWriter
     * @return 
     */
    public ClassWriter generatorClassHeader(ClassWriter classWriter){
        return classWriter;
    }
    
    /**
     * 生成类里面的字段信息
     * @param classWriter
     * @return 
     */
    public ClassWriter generatorFields(ClassWriter classWriter){
        return classWriter;
    }
    
    /**
     * 生成类里面的方法信息
     * @param classWriter
     * @return 
     */
    public ClassWriter generatorMethods(ClassWriter classWriter){
        return classWriter;
    }
}
