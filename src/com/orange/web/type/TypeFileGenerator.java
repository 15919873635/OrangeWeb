/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.web.type;

import com.orange.web.type.bean.AnnotationVisit;
import com.orange.web.type.bean.MethodVisit;
import com.orange.web.type.bean.TypeVisit;
import com.orange.web.type.bean.FieldVisit;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import jdk.internal.org.objectweb.asm.ClassWriter;

/**
 * class文件生成器
 * @author lining
 */
public class TypeFileGenerator implements TypeGenerator{
    public  ClassWriter classWriter;
    public TypeFileGenerator(ClassWriter classWriter){
        this.classWriter = classWriter;

    }
    @Override
    public void generator(ClassWriter classWriter) {
        if(classWriter != null)
            this.classWriter = classWriter;
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
     * @param classVisit
     * @param classWriter
     * @return 
     */
    public ClassWriter generatorClassHeader(TypeVisit classVisit,ClassWriter classWriter){
        classWriter.visit(classVisit.getVersion(), 
                        classVisit.getAccess(),
                        classVisit.getName(), 
                        classVisit.getSignature(),
                        classVisit.getSuperName(),
                        classVisit.getInterfaces());
        return classWriter;
    }
    
    /**
     * 生成类里面的字段信息
     * @param fieldVisits
     * @param classWriter
     * @return 
     */
    public ClassWriter generatorFields(Iterator<FieldVisit> fieldVisits, ClassWriter classWriter){
        if(fieldVisits != null){
            while(fieldVisits.hasNext()){
                FieldVisit fieldVisit = fieldVisits.next();
                classWriter.visitField(fieldVisit.getAccess(),
                                    fieldVisit.getName(), 
                                    fieldVisit.getDesc(), 
                                    fieldVisit.getSignature(), 
                                    fieldVisit.getValue());
            }
        }
        return classWriter;
    }
    
    /**
     * 生成类里面的方法信息
     * @param methodVisits
     * @param classWriter
     * @return 
     */
    public ClassWriter generatorMethods(Iterator<MethodVisit> methodVisits, ClassWriter classWriter){
        if(methodVisits != null){
            while(methodVisits.hasNext()){
                MethodVisit methodVisit = methodVisits.next();
                classWriter.visitMethod(methodVisit.getAccess(),
                                    methodVisit.getName(), 
                                    methodVisit.getDesc(), 
                                    methodVisit.getSignature(), 
                                    methodVisit.getExceptions());
            }
        }
        return classWriter;
    }
    /**
     * 生成类里面的注解信息
     * @param annotationVisits
     * @param classWriter
     * @return 
     */
    public ClassWriter generatorAnnotation(Iterator<AnnotationVisit> annotationVisits, ClassWriter classWriter){
        if(annotationVisits != null){
            while(annotationVisits.hasNext()){
                AnnotationVisit annotationVisit = annotationVisits.next();
                if(annotationVisit != null){
                    classWriter.visitAnnotation(annotationVisit.getDesc(),
                                                annotationVisit.isVisible());
                    if(annotationVisit.getPlainWrapSet() != null && !annotationVisit.getPlainWrapSet().isEmpty()){
                        Iterator<AnnotationVisit.AnnotationPlainWrap> iterator = annotationVisit.getPlainWrapSet().iterator();
                        while(iterator.hasNext()){
                            AnnotationVisit.AnnotationPlainWrap plainWrap = iterator.next();
                        }
                    } if(annotationVisit.getEnumWrapSet() != null && !annotationVisit.getEnumWrapSet().isEmpty()){
                    } if(annotationVisit.getAnnotationWrapSet() != null && !annotationVisit.getAnnotationWrapSet().isEmpty()){
                    } if(annotationVisit.getArrayWrapSet() != null && !annotationVisit.getArrayWrapSet().isEmpty()){
                    }
                }
            }
        }
        return classWriter;
    }
}
