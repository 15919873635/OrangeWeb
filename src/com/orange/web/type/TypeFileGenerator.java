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
import com.orange.web.type.bean.TypeFragmentation;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import jdk.internal.org.objectweb.asm.AnnotationVisitor;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.FieldVisitor;

/**
 * class文件生成器
 * @author lining
 */
public class TypeFileGenerator implements TypeGenerator{
    public  ClassWriter classWriter;
    public TypeFileGenerator(ClassWriter classWriter){
        this.classWriter = classWriter;
    }
    public TypeFileGenerator(){
        this.classWriter = new ClassWriter(0);
    }
    public void generator(TypeFragmentation typeFragmentation) throws Exception{
        generator(typeFragmentation, null);
    }
    @Override
    public void generator(TypeFragmentation typeFragmentation, ClassWriter classWriter) throws Exception{
        if(classWriter != null)
            this.classWriter = classWriter;
        if(typeFragmentation != null){
            generatorClassHeader(typeFragmentation.getTypeVisit(),this.classWriter);
            generatorAnnotation(typeFragmentation.getAnnotationVisit(), this.classWriter);
            generatorFields(typeFragmentation.getFieldVisit(),this.classWriter);
            generatorMethods(typeFragmentation.getMethodVisit(), this.classWriter);
        }
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
     * @throws java.lang.ClassNotFoundException
     */
    public void generatorClassHeader(TypeVisit classVisit,ClassWriter classWriter) throws ClassNotFoundException{
        if(classVisit != null){
            classWriter.visit(classVisit.getVersion(), 
                            classVisit.getAccess(),
                            classVisit.getName(), 
                            classVisit.getSignature(),
                            classVisit.getSuperName(),
                            classVisit.getInterfaces());
        }    
    }
    
    /**
     * 生成类里面的字段信息
     * @param fieldVisits
     * @param classWriter
     */
    public void generatorFields(Iterator<FieldVisit> fieldVisits, ClassWriter classWriter){
        if(fieldVisits != null){
            while(fieldVisits.hasNext()){
                FieldVisit fieldVisit = fieldVisits.next();
                if(fieldVisit != null){
                    FieldVisitor visitor = classWriter.visitField(fieldVisit.getAccess(),
                                    fieldVisit.getName(), 
                                    fieldVisit.getDesc(), 
                                    fieldVisit.getSignature(), 
                                    fieldVisit.getValue());
                    if(fieldVisit.getAnnotationSet() != null && !fieldVisit.getAnnotationSet().isEmpty())
                        generatorAnnotation(fieldVisit.getAnnotationSet().iterator(),classWriter);
                    visitor.visitEnd();
                }
            }
        }
    }
    
    /**
     * 生成类里面的方法信息
     * @param methodVisits
     * @param classWriter
     */
    public void generatorMethods(Iterator<MethodVisit> methodVisits, ClassWriter classWriter){
        if(methodVisits != null){
            while(methodVisits.hasNext()){
                MethodVisit methodVisit = methodVisits.next();
                if(methodVisit != null){
                    classWriter.visitMethod(methodVisit.getAccess(),
                                    methodVisit.getName(), 
                                    methodVisit.getDesc(), 
                                    methodVisit.getSignature(), 
                                    methodVisit.getExceptions());
                }
            }
        }
    }
    /**
     * 生成类里面的注解信息
     * @param annotationVisits
     * @param classWriter
     */
    public void generatorAnnotation(Iterator<AnnotationVisit> annotationVisits, ClassWriter classWriter){
        if(annotationVisits != null){
            while(annotationVisits.hasNext()){
                AnnotationVisit annotationVisit = annotationVisits.next();
                if(annotationVisit != null){
                    AnnotationVisitor vistor =  classWriter.visitAnnotation(annotationVisit.getDesc(),
                                                annotationVisit.isVisible());
                    if(annotationVisit.getPlainWrapSet() != null && !annotationVisit.getPlainWrapSet().isEmpty()){
                        Iterator<AnnotationVisit.AnnotationPlainWrap> iterator = annotationVisit.getPlainWrapSet().iterator();
                        while(iterator.hasNext()){
                            AnnotationVisit.AnnotationPlainWrap plainWrap = iterator.next();
                            vistor.visit(plainWrap.getPlainName(), plainWrap.getPlainValue());
                        }
                    } if(annotationVisit.getEnumWrapSet() != null && !annotationVisit.getEnumWrapSet().isEmpty()){
                        Iterator<AnnotationVisit.AnnotationEnumWrap> iterator = annotationVisit.getEnumWrapSet().iterator();
                        while(iterator.hasNext()){
                            AnnotationVisit.AnnotationEnumWrap enumWrap = iterator.next();
                            vistor.visitEnum(enumWrap.getEnumName(), enumWrap.getEnumDesc(), enumWrap.getEnumValue());
                        }
                    } if(annotationVisit.getAnnotationWrapSet() != null && !annotationVisit.getAnnotationWrapSet().isEmpty()){
                        
                    } if(annotationVisit.getArrayWrapSet() != null && !annotationVisit.getArrayWrapSet().isEmpty()){
                        Iterator<AnnotationVisit.AnnotationArrayWrap> iterator = annotationVisit.getArrayWrapSet().iterator();
                        while(iterator.hasNext()){
                            AnnotationVisit.AnnotationArrayWrap arrayWrap = iterator.next();
                            vistor.visitArray(arrayWrap.getArrayValue());
                        }
                    }
                    vistor.visitEnd();
                }
            }
        }
    }

    public ClassWriter getClassWriter() {
        return classWriter;
    }

    public void setClassWriter(ClassWriter classWriter) {
        this.classWriter = classWriter;
    }
}
